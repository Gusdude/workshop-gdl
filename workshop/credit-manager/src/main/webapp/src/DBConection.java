import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConection {

	private Connection conn;
	
	public Connection connectToOracle(){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:testdb", "System", "101889");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connection established");
		
		return conn;
	}

}
