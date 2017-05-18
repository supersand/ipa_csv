package ipa_2017;

import java.sql.*;

public class CSVModel
{
	public static void main (String[] args)
	{ 
		try
		{ 
	        //Baut Verbindung mit der SQL-Datenbank auf
			String url = "jdbc:mysql://192.168.25.97:3306/log_db"; 
	        Connection conn = DriverManager.getConnection(url,"csv","ipa2017"); 
	        Statement st = conn.createStatement(); 
	        
	        //SQL-Query zum Einlesen der CSV-Textdatei
	        st.executeUpdate("LOAD DATA LOCAL INFILE 'F:/Users/DanielTuan/Documents/IPA 2017/workspace/ipa_2017/Fehler0.csv'INTO TABLE log_db.logfiles\r\n" + 
	        		" CHARACTER SET LATIN1\r\n" + 
	        		" FIELDS ENCLOSED BY '\"'\r\n" + 
	        		" TERMINATED BY ','\r\n" + 
	        		" LINES TERMINATED BY '\\r\\n'" +
	        		" IGNORE 1 LINES\r\n" +
	        		" (@none, @none, @none, @none, @none, Var1, @none, @none, @none, @none, @none, @none, @none, TimeString, MsgText, PLC);");
	        
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