package com.cardgame.controler;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Random;

import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cardgame.model.CardModel;
import com.cardgame.services.UserServices;
import com.cardgame.utils.Tools;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import javassist.bytecode.analysis.Util;

/**
 * Servlet implementation class ServletDisplayCard
 */
@WebServlet("/cards")
public class ServletDisplayCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDisplayCard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		URL obj = new URL("http://localhost:8080/WebServiceCard/rest/servicescard/cards");
        HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
        httpURLConnection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(httpURLConnection.getInputStream()));
        String inputLine;
        StringBuffer response1 = new StringBuffer();
         while ((inputLine = in.readLine()) != null) {
           response1.append(inputLine);
         } in .close();

         
         ObjectMapper mapper = new ObjectMapper();
         CardModel[] cards= mapper.readValue(response1.toString(), CardModel[].class);

         Random r = new Random();
         int index =  r.nextInt(cards.length);
         CardModel card = cards[index];
         request.setAttribute("name", card.getName());
         request.setAttribute("description", card.getDescription());
         request.setAttribute("family", card.getFamily());
         request.setAttribute("url", card.getImgUrl());
         request.setAttribute("hp", card.getHp());
         request.setAttribute("energy", card.getEnergy());
         request.setAttribute("attack", card.getAttack());
         request.setAttribute("defence", card.getDefence());
         request.setAttribute("attack", card.getAttack());
         request.getRequestDispatcher("/WEB-INF/Card.jsp").
         forward(request,response);
        	 
         
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
