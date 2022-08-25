package svarts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/home")
public class HomePage extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
   
	

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("uname");
		String pass=request.getParameter("password");
		PrintWriter pw=response.getWriter();
		if(username.equals("admin")) {
			
			if(pass.equals("manager"))
			{
			RequestDispatcher re=request.getRequestDispatcher("admin.html");
			re.include(request, response);
			}
			else
			{
				pw.print("Incorrect Pasword");
			}
		}else
		{
			pw.print("User Name Not Mathched");
		}
	}

}
