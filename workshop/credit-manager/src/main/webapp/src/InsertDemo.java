import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class InsertDemo {
	
	public void insertIntoTable(){
		DBConection db = new DBConection();
		Connection conn = db.connectToOracle();
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			String query = "insert into employee values(311,'Yala','Hero',20,sysdate,3000,400,1345)";
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("value inserted...");
	}
	
	public void readFromTable(){
		
		DBConection db = new DBConection();
		Connection conn = db.connectToOracle();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String query = "select * from employee";
			ResultSet rs = stmt.executeQuery(query);
			displayResult(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
}
