package com.cardgame.controler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cardgame.model.CardModel;
import com.cardgame.utils.Tools;

/**
 * Servlet implementation class ServletAddCard
 */
@WebServlet("/addData")
public class ServletAddCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddCard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CardModel card = new CardModel();
		String Name = request.getParameter("Name");
		String Description = request.getParameter("Description");
		String Family = request.getParameter("Family");
		String Hp = request.getParameter("Hp");
		String Energy = request.getParameter("Energy");
		String Attack = request.getParameter("Attack");
		String Defence = request.getParameter("Defence");
		String Url = request.getParameter("Url");
		
		//Si tous les champs sont bien renseignés
		if(Name != "" && Description != "" && Family != "" && Hp != "" && Energy != "" && Attack != "" && Defence != "" && Url != "") {
			card.setName(Name);
			card.setDescription(Description);
			card.setFamily(Family);
			try {
				card.setHp(Integer.parseInt(Hp));
				card.setEnergy(Integer.parseInt(Energy));
				card.setDefence(Integer.parseInt(Defence));
				card.setAttack(Integer.parseInt(Attack));
			} catch (Exception e) {
				this.ErrorRedirect(request, response);
			}
			card.setImgUrl(Url);
			
			//Envoi de l'objet CardModel au webservice
			URL obj = new URL("http://localhost:8080/WebServiceCard/rest/servicescard/add");
	        HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
	        httpURLConnection.setRequestMethod("POST"); 
	        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	        httpURLConnection.setDoOutput(true);
	        OutputStream os = httpURLConnection.getOutputStream();
	        OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
	        osw.write(Tools.toJsonString(card));
	        osw.flush();
	        osw.close();
            
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(httpURLConnection.getInputStream()));
                    String inputLine;
                    StringBuffer response1 = new StringBuffer();
                     while ((inputLine = in.readLine()) != null) {
                       response1.append(inputLine);
                     } in .close();
            
            request.setAttribute("success", "Card added");
            request.getRequestDispatcher("/WEB-INF/AddCard.jsp").
			forward(request,response);
	        
		} 
		//Sinon on renvoie sur le formulaire avec une erreur
		else {
			this.ErrorRedirect(request, response);
		}
		
	}
	
	private void ErrorRedirect(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("error", "You must provide all information");
		try {
			request.getRequestDispatcher("/WEB-INF/AddCard.jsp").
			forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
