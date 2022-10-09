package svarts;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/studentno")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con;
     
	

	
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adno=request.getParameter("admission_number");
	
		int addno=Integer.parseInt(adno);
		
		String optipon=request.getParameter("print");
		
		switch(optipon)
		{
		case "Print TC":optipon ="retrivingdata.jsp";break;
		case "Print Study":optipon="forStudy.jsp";break;
		case "Edit":optipon="Editstudnet.jsp";
			
		}
	
			
			try {
			       con=DBConnection.getCon();
				PreparedStatement ps=con.prepareStatement("select * from Tc where ADMNO ="+addno+"");
				PreparedStatement psfortcno=con.prepareStatement("select * from Tcno where Tcsvno =1");
				ResultSet re=ps.executeQuery();
				ResultSet refortcno=psfortcno.executeQuery();
				
				ServletContext sc=request.getServletContext();	
				sc.setAttribute("print", re);
				sc.setAttribute("Tcno", refortcno);
				
				
					if(re.next()&&refortcno.next())
					{
						
					RequestDispatcher rd=request.getRequestDispatcher(optipon);
					rd.forward(request, response);
					}
					else
					{
					
					RequestDispatcher rd=request.getRequestDispatcher("forTc.html");
					rd.include(request, response);
				}	
					
			} 
			catch (SQLException e) {
				
				e.printStackTrace();
			}
			

	}
		
	
	
	
	
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
}
