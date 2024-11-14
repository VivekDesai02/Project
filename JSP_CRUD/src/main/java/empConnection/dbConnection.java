package empConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {
	
	public static Connection connect() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
