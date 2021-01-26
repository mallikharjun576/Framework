package TestNGPractice;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class JDBCConnection {
	
			
  @Test
  public void getDataFromDB() throws ClassNotFoundException {
	  java.sql.Connection con =null;
	  ResultSet resSet = null;
	  
	  try {
		  String DataBaseURL = "jdbc:sqlserver://localHost:1433;”+ “databaseName=BikeStores; integratedSecurity=true;";
		  
		  String username = "sa";
		  String password = "Arjun@576";
		  
		//Initialize Sqldriver instance
		  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		  
		// Creating the connection providing URL and username password
		  con = DriverManager.getConnection(DataBaseURL, username, password);
		  
		  System.out.println("Is connection closed: "+con.isClosed());
		 
		// Providing the query under createStatement parameter
		  Statement sqlStatement = con.createStatement();
		  String sqlQuery = "SELECT * FROM BikeStores.sales.customers where customer_id <= 3";
		  
		//Command to execute query and capturing all the result under Result set
		  resSet = sqlStatement.executeQuery(sqlQuery);
		  
		  while (resSet.next()) {
			  System.out.println(resSet.getString("first_name")+" "+resSet.getString("email"));
			  }
		  
		  con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		} 
	  
  }
}
