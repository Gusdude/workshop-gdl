package com.recluit.lab.action;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class CloseAction {
	
	private String id;
	private float resultado = 1.0f;
	
	public String execute() throws Exception{
			
		DBConection db = new DBConection();
		Connection conn = db.connectToOracle();
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			String query = "SELECT remaining_amount FROM payments WHERE LOAN_ID ='" + id + "'order by remaining_amount";
						
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){
				resultado = rs.getFloat(1);
			}
			
			if(resultado == 0.0f){
				//Update table 
				query = "UPDATE LOANS SET STATUS = 'N' WHERE ID = '" + id + "'";
				stmt.executeQuery(query);
				return "closeSuccess";
				
			}else if (resultado != 0.0f){
				return "closeError";
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "someError";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getResultado() {
		return resultado;
	}

	public void setResultado(float resultado) {
		this.resultado = resultado;
	}

}
