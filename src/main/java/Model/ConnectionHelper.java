package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//SINGLETON DESIGN PATTERN
public class ConnectionHelper {
	
	static Connection connection=null;
	
	
	 static String url="jdbc:mysql://localhost:3306/sqlsimulator";
	 static String userName="root";
	 static String password="hrutik";
	
	private ConnectionHelper() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,userName,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection helper() {
		if (connection==null) {
			new ConnectionHelper();
		}
		return connection;
	}

}
