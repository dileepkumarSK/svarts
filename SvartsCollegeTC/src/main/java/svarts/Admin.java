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
		System.out.println(optipon);
			
			try {
			       con=DBConnection.getCon();
				PreparedStatement ps=con.prepareStatement("select * from Tc where ADMNO ="+addno+"");
				ResultSet re=ps.executeQuery();
				ServletContext sc=request.getServletContext();	
				sc.setAttribute("print", re);
				
				if(optipon.equals("print TC")) 
				{
					if(re.next())
					{
					RequestDispatcher rd=request.getRequestDispatcher("retrivingdata.jsp");
					rd.include(request, response);
					}
					else
					{
					
					RequestDispatcher rd=request.getRequestDispatcher("forTc.html");
					rd.include(request, response);
					
					
					}
				
					
				}
				else if(optipon.equals("Print Study"))
				{
					
					if(re.next())
					{
						
						RequestDispatcher rd=request.getRequestDispatcher("forStudy.jsp");
						rd.include(request, response);
					}
					else
					{
						
						RequestDispatcher rd=request.getRequestDispatcher("forTc.html");
						rd.include(request, response);
						
						
					}
					
				}
				
				else 
				{
					
					if(re.next())
					{
						
						RequestDispatcher rd=request.getRequestDispatcher("Editstudnet.jsp");
						rd.include(request, response);
					}
					else
					{
						
						RequestDispatcher rd=request.getRequestDispatcher("forTc.html");
						rd.include(request, response);
						
						
					}
					
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
