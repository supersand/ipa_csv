package ipa_2017;

import java.sql.*;

public class TableView
{
	public static void main (String[] args)
	{ 
		try
		{ 
	        //Baut Verbindung mit der SQL-Datenbank auf
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://192.168.25.97:3306/log_db"; 
	        Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,"csv","ipa2017"); 
	        Statement st = conn.createStatement(); 
	        
	        //Erstellen der SQL-Abfrage in einem String
	        String query = "SELECT * FROM log_db.logfiles";
	        
	        //
	        ResultSet rs = st.executeQuery(query);
	        
	        while (rs.next())
	        {
	          int id = rs.getInt("id");
	          String Var1 = rs.getString("Var1");
	          Date TimeString = rs.getDate("TimeString");
	          String MsgText = rs.getString("MsgText");
	          String PLC = rs.getString("PLC");
		      
	          // print the results
		      System.out.format("%s, %s, %s, %s, %s \n", id, Var1, TimeString, MsgText, PLC);
	        }
	        
	        System.out.print("Successful!");
	        conn.close(); 
	     }
	       	catch (Exception e)
	       	{ 
	       		System.err.println("Exception caught:"); 
	       		System.err.println(e.getMessage()); 
	       	} 
	 
	}
}
