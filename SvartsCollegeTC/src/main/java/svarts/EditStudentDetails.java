package svarts;

import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editStudentDetails")
public class EditStudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Connection con;
	   	java.sql.Date mySqlDate1,mySqlDate2;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		String admno=request.getParameter("admnumber");
		int number=Integer.parseInt(admno);
		System.out.println(number);
		
		try {
		       con=DBConnection.getCon();
		       
		       PreparedStatement ps=con.prepareStatement("select * from Tc where ADMNO ="+number+"");
		       
		
			
		
			
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		

}
	
}