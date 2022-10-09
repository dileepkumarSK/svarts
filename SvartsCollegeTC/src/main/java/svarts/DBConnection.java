package svarts;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;

public class DBConnection 
{
	static Connection con=null;
	private DBConnection() {}
	static
	{
		try
		{
			//String databaseURL = "jdbc:ucanaccess://e://Java//JavaSE//MsAccess//Contacts.accdb";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "C##Dileep", "7036");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public static Connection getCon()
	{
		return con;
		
	}
}
