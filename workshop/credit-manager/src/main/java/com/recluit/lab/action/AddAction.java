package com.recluit.lab.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//import com.recluit.lab.restclient.RestClient;

public class AddAction {
	private String RFC = ChooseAction.getRFC();
	private float loan;
	private String name;
	private String lastname;
	
	
	public String execute(){
		
		DBConection db = new DBConection();
		Connection conn = db.connectToOracle();
		Statement stmt = null;
		
		
		try {
			stmt = conn.createStatement();
			String query = "SELECT QUALIFICATION FROM customer WHERE RFC ='" + RFC + "'";
			ResultSet rs = stmt.executeQuery(query);
			String result = displayResult(rs);
			
			if(result.equalsIgnoreCase("GOOD")||result.equalsIgnoreCase("VERY GOOD")||result.equalsIgnoreCase("EXCELENT")){
				try {
					stmt = conn.createStatement();
					query = "INSERT INTO loans VALUES (loanid.nextval,'" + RFC+ "'," + loan + ",'GOOD', sysdate + 365,'Y')";
					stmt.executeUpdate(query);
					
/*					String url = "112";
					RestClient client = new RestClient();
					System.out.println( client.addLoan(url));
*/					
					
					
				} catch (SQLException e) {
					e.printStackTrace();
					//return "someError";
				}
				finally{
					if(stmt != null){
						try {
							stmt.close();
						} catch (SQLException e) {
							e.printStackTrace();
							//return "someError";
						}
					}
				}
				System.out.println("value inserted...");
				return "creditSuccess";
			}
			
			if(result.equalsIgnoreCase("BAD")||result.equalsIgnoreCase("VERY BAD")){
				return "creditError";
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			//return "someError";
		}
		finally{
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
					//return "someError";
				}
			}
		}
		return "someError";
	}


	public float getLoan() {
		return loan;
	}


	public void setLoan(float loan) {
		this.loan = loan;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	private String displayResult(ResultSet rs) throws SQLException {
		
		ResultSetMetaData metaData;
		
		metaData = rs.getMetaData();
		int columns = metaData.getColumnCount();
		
		System.out.println();
		String result = null;
		while(rs.next()){
			for(int i = 1; i<=columns; i++){
				//System.out.print(rs.getString(i)+"\t\t");
				result = rs.getString(i);
			}
		}
		System.out.println(result);
		return result;
	}

}
