package com.cardgame.controler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cardgame.model.CardModel;
import com.cardgame.utils.Tools;

public class CardDao {
	private final static String DB_LOCATION = "127.0.0.1";
	private final static int DB_PORT = 5432;
	private final static String DB_NAME = "Cards";
	private final static String DB_USER = "postgres";
	private final static String DB_PWD = "admin";

	private String dblocation;
	private int dbport;
	private String dbName;
	private String username;
	private String pwd;

	public CardDao(String dblocation, int dbport, String dbName, String username, String pwd) {
		this.dblocation = dblocation;
		this.dbport = dbport;
		this.dbName = dbName;
		this.username = username;
		this.pwd = pwd;
	}

	public CardDao() {
		this.dblocation = DB_LOCATION;
		this.dbport = DB_PORT;
		this.dbName = DB_NAME;
		this.username = DB_USER;
		this.pwd = DB_PWD;
	}

	public void addCard(CardModel card) {
		try {
			 Class.forName("org.postgresql.Driver");
			java.sql.Connection cnx = java.sql.DriverManager.getConnection(
					"jdbc:postgresql://" + this.dblocation + ":" + this.dbport + "/" + this.dbName, this.username, this.pwd);
			PreparedStatement st = cnx.prepareStatement("INSERT INTO \"Card\" (name, description,family,hp,energy,attack,defence,\"imgUrl\") VALUES (?,?,?,?,?,?,?,?);");
			st.setString(1, card.getName());
			st.setString(2, card.getDescription());
			st.setString(3, card.getFamily());
			st.setInt(4, card.getHp());
			st.setInt(5, card.getEnergy());
			st.setInt(6, card.getAttack());
			st.setInt(7, card.getDefence());
			st.setString(8, card.getImgUrl());
			st.executeUpdate();//
			//cnx.commit();
			st.close();
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public CardModel getCard(String id) {
		CardModel newCard = null;
		try {
			 Class.forName("org.postgresql.Driver");
				java.sql.Connection cnx = java.sql.DriverManager.getConnection(
						"jdbc:postgresql://" + this.dblocation + ":" + this.dbport + "/" + this.dbName, this.username, this.pwd);
			PreparedStatement st = cnx.prepareStatement("select * from \"Card\" where id=?");
			st.setString(1, id);
			ResultSet rst = st.executeQuery();
			while (rst.next()) {
				newCard = new CardModel(rst.getString("name"), rst.getString("description"), rst.getString("family"),
						rst.getInt("hp"), rst.getInt("energy"), rst.getInt("defence"), rst.getInt("attack"),
						rst.getString("imgUrl"));
				newCard.setId(rst.getString("id"));
			}
			// st.executeUpdate("");//

			rst.close();
			st.close();
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newCard;
	}

	public CardModel getCardByName(String name) {
		CardModel newCard = null;
		try {
			 Class.forName("org.postgresql.Driver");
				java.sql.Connection cnx = java.sql.DriverManager.getConnection(
						"jdbc:postgresql://" + this.dblocation + ":" + this.dbport + "/" + this.dbName, this.username, this.pwd);
			PreparedStatement st = cnx.prepareStatement("select * from \"Card\" where name=?");
			st.setString(1, name);
			ResultSet rst = st.executeQuery();
			while (rst.next()) {
				newCard = new CardModel(rst.getString("name"), rst.getString("description"), rst.getString("family"),
						rst.getInt("hp"), rst.getInt("energy"), rst.getInt("defence"), rst.getInt("attack"),
						rst.getString("imgUrl"));
				newCard.setId(rst.getString("id"));
			}
			rst.close();
			st.close();
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newCard;
	}

	public List<CardModel> getCards() {
		List<CardModel> cardList;
		cardList = new ArrayList<>();
		try {

			 Class.forName("org.postgresql.Driver");
				java.sql.Connection cnx = java.sql.DriverManager.getConnection(
						"jdbc:postgresql://" + this.dblocation + ":" + this.dbport + "/" + this.dbName, this.username, this.pwd);
			PreparedStatement st = cnx.prepareStatement("select * from \"Card\"");
			ResultSet rst = st.executeQuery();
			while (rst.next()) {
				CardModel newCard = new CardModel(rst.getString("name"), rst.getString("description"),
						rst.getString("family"), rst.getInt("hp"), rst.getInt("energy"), rst.getInt("defence"),
						rst.getInt("attack"), rst.getString("imgUrl"));
				newCard.setId(rst.getString("id"));
				cardList.add(newCard);
			}
			// st.executeUpdate("");//
			rst.close();
			st.close();
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cardList;
	}

	public String getCardsJson() {
		String jsonResult;
		List<CardModel> cardList = getCards();
		jsonResult = "[";
		boolean first=true;
		for (CardModel cardModel : cardList) {
			if(first){
				jsonResult=jsonResult+ Tools.toJsonString(cardModel);
				first=false;
			}else{
				jsonResult=jsonResult+","+Tools.toJsonString(cardModel);
			}
		}
		jsonResult=jsonResult+"]";
		
		return jsonResult;
	}

}
