package com.recluit.lab.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

public class ChooseAction extends ActionSupport{

	private static final long serialVersionUID = -3561538112932319256L;

	private static String RFC;
	private String options;


	public String execute() throws Exception{
				
		System.out.println(options + "\n");
		System.out.println(RFC + "\n");
		System.out.println("length" + RFC.length() + "\n"); 
		
		if(RFC.length() >= 10){
			
			switch(options){
			case "1": return "close";
			case "2": return "new";
			case "3": return "payment";
			case "4": displayAction(); break;
			
			}
		}
		else{
			
			return ERROR;
		}
		return null;
		
	}
	
	
	public String displayAction(){
		
		DBConection db = new DBConection();
		Connection conn = db.connectToOracle();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String query = "select * from loans where RFC = '"+ RFC +"'";
			ResultSet rs = stmt.executeQuery(query);
			displayResult(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private void displayResult(ResultSet rs) throws SQLException {
	
		ResultSetMetaData metaData;
		
		metaData = rs.getMetaData();
		int columns = metaData.getColumnCount();
		
		for(int i = 1; i<=columns; i++){
			System.out.print(metaData.getColumnName(i)+"\t\t");
		}
		
		System.out.println();
		
		while(rs.next()){
			for(int i = 1; i<=columns; i++){
				System.out.print(rs.getString(i)+"\t\t");
			}
			System.out.println();
		}
		
	}


	public static String getRFC() {
		return RFC;
	}


	public void setRFC(String rFC) {
		RFC = rFC;
	}


	public String getOptions() {
		return options;
	}


	public void setOptions(String options) {
		this.options = options;
	}
	
	
	
}
