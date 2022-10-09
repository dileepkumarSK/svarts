package svarts;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/finding")
public class Findingoriginal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String adno = request.getParameter("number");
		adno = adno.replaceAll("\\s+", "");
		String tcnost;
		int addno = Integer.parseInt(adno);
		ResultSet re,rc;
		Connection con = DBConnection.getCon();
		try {
			
			PreparedStatement pscheckingtcnonull = con.prepareStatement("select * from Tc where ADMNO ="+addno+"");
			 rc = pscheckingtcnonull.executeQuery();
			
			if(rc.next()) {
			
				System.out.println(rc.getString(22));
			if (rc.getString(22)==null)
			{
				PreparedStatement pstcno = con.prepareStatement("select * from TCno where  TCSVNO =" + 1 + "");
				 re = pstcno.executeQuery();
				if(re.next())
				{
				System.out.println( re.getInt(2));
				String countfrom =""+ re.getInt(2);
				Calendar d = new GregorianCalendar();
				 tcnost = countfrom + "/" + d.get(Calendar.YEAR) + "";
					System.out.println(tcnost);
				
			PreparedStatement pstcnoupdateing = con.prepareStatement("UPDATE Tc set  tcno='" + tcnost + "' where ADMNO =" + addno + "");
			int m = pstcnoupdateing.executeUpdate();
			if (m == 0)
				System.out.println("tcno updateed");
			
				}
			PreparedStatement psfortcno = con.prepareStatement("UPDATE Tcno set  COUNT=count+1 where  TCSVNO =" + 1 + "");
			int y = psfortcno.executeUpdate();
			
			if (y== 1 )
				System.out.println("SUCESS count increase");
			
			
			
			}
			}
			
			PreparedStatement ps = con.prepareStatement("UPDATE Tc set  COUNT=1 where ADMNO =" + addno + "");
			
			int x = ps.executeUpdate();
			if (x == 1 )
				System.out.println("SUCESS");

			RequestDispatcher rd = request.getRequestDispatcher("forTc.html");
			rd.include(request, response);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
