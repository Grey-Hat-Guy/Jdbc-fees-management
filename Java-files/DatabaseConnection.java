package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	public Connection databaselink;
	
	public Connection getConnection() {
		
		String urlString = "jdbc:mysql://localhost/fees_management";
		String userString = "root";
		String passString = "mysqlpass";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			databaselink = DriverManager.getConnection(urlString, userString, passString);
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return databaselink;
		
	}

}
