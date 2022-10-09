
package svarts;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/newentry")
public class NewStudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con;
   	java.sql.Date mySqlDate1,mySqlDate2;
	
   
	protected void service(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		String admno=request.getParameter("admnumber");
		int number=Integer.parseInt(admno);
	
		
		try {
		String Studentname=request.getParameter("nameofst");
		String StudentSurname=request.getParameter("surname");
		String fathername=request.getParameter("fathername");
		String fathersurname=request.getParameter("fathersurname");
		String NRC=request.getParameter("nationality")+"-"+request.getParameter("Religion")
		+"-"+request.getParameter("Caste")+"-"+request.getParameter("subcaste");
		String gender=request.getParameter("gender");
		String dateofbirth=request.getParameter("dateofbirth");
		String dateofadmission=request.getParameter("dateofadmission");
		
		dateofbirth=dateofbirth.substring(8)+"-"+dateofbirth.substring(5,7)+"-"+dateofbirth.substring(0,4);
		
		dateofadmission=dateofadmission.substring(8)+"-"+dateofadmission.substring(5,7)+"-"+
				dateofadmission.substring(0,4);
		
		
		
		System.out.println(dateofbirth);
		System.out.println(dateofadmission);
		DateToWords num = new DateToWords();
		
		
		
		String dateofbirthinwords=num.convert((Integer.parseInt(dateofbirth.substring(0,2))))+"-"+
				num.convert((Integer.parseInt(dateofbirth.substring(3,5))))+"-"+
				num.convert((Integer.parseInt(dateofbirth.substring(6))));
		
		System.out.println(dateofbirthinwords);
		
		
		String dateofadmissioninwords=num.convert((Integer.parseInt(dateofadmission.substring(0,2))))+
				"-"+num.convert((Integer.parseInt(dateofadmission.substring(3,5))))+"-"+
				num.convert((Integer.parseInt(dateofadmission.substring(6))));
		
		System.out.println(dateofadmissioninwords);
		
		String Group=request.getParameter("Group");
		String Medium=request.getParameter("Medium");
		String secSubject=request.getParameter("subject");
		String specilization1=request.getParameter("specilization1");
		String specilization2=request.getParameter("specilization2");
		String specilization3=request.getParameter("specilization3");
		
		String duefees=request.getParameter("duefees");
		String year1=request.getParameter("year");
		String stye=request.getParameter("syear");
		int year=Integer.parseInt(year1);
		int jyear=Integer.parseInt(stye);
		
		
		con=DBConnection.getCon();
	
		PreparedStatement ps=con.prepareStatement("insert into tc values(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,?,?)");
		
		ps.setInt(1, number);
		ps.setString(2, Studentname.toUpperCase());
		ps.setString(3, StudentSurname.toUpperCase());
		ps.setString(4, fathername.toUpperCase());
		ps.setString(5, fathersurname.toUpperCase());
		ps.setString(6, NRC.toUpperCase());
		ps.setString(7, gender.toUpperCase());
		ps.setString(8,dateofbirth);
		ps.setString(9, dateofbirthinwords.toUpperCase());
		ps.setString(10,Medium.toUpperCase() );
		ps.setString(11, secSubject.toUpperCase());
		ps.setString(12, specilization1.toUpperCase());
		ps.setString(13, specilization2.toUpperCase());
		ps.setString(14,specilization3.toUpperCase() );
		
		ps.setString(15, dateofadmission);
		ps.setString(16, duefees.toUpperCase());
	
		ps.setInt(17, year);
		
		ps.setString(18,Group.toUpperCase() );
		ps.setInt(19, jyear);
		ps.setString(20, dateofadmissioninwords.toUpperCase());
		ps.setInt(21, 0);
		ps.setString(22, null);
		int x=ps.executeUpdate();
		if(x==1)
		{
			System.out.println("sucess");
			ps.close();
		}
		else {
			System.out.println("fail");
		}
		
		RequestDispatcher re =request.getRequestDispatcher("newStudentDet.html");
		re.include(request, response);
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}