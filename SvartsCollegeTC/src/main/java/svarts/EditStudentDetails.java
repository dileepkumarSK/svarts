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
	PreparedStatement ps;
	int number, countforcoupates;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String adno = request.getParameter("number");
		adno = adno.replaceAll("\\s+", "");
		number = Integer.parseInt(adno);

		System.out.println(number + " number");
		con = DBConnection.getCon();

		String Studentname = request.getParameter("nameofst");

		if (!Studentname.equals("")) {
			Studentname = "STNAME = " + "\'" + Studentname + "\'";
			this.update(Studentname);
			System.out.println(Studentname);
		}

		String StudentSurname = request.getParameter("surname");

		if (!StudentSurname.equals("")) {
			StudentSurname = " STSNAME = " + "\'" + StudentSurname + "\'";
			this.update(StudentSurname);
			System.out.println(StudentSurname);
		}
		String fathername = request.getParameter("fathername");

		if (!fathername.equals("")) {
			fathername = " SFNAME = " + "\'" + fathername + "\'";
			this.update(fathername);
			System.out.println(fathername);
		}

		String fathersurname = request.getParameter("fathersurname");

		if (!fathersurname.equals("")) {
			fathersurname = "  SFSNAME = " + "\'" + fathersurname + "\'";
			this.update(fathersurname);
			System.out.println(fathersurname);
		}

		String NRC = request.getParameter("nationality") + "-" + request.getParameter("Religion") + "-"
				+ request.getParameter("Caste") + "-" + request.getParameter("subcaste");

		if (!NRC.equals("---")) {
			NRC = "  NRC = " + "\'" + NRC + "\'";
			this.update(NRC);
			System.out.println(NRC);
		}

		String gender = request.getParameter("gender");
		if (gender != null) {
			gender = "  GENDER = " + "\'" + gender + "\'";
			this.update(gender);
			System.out.println(gender);

		}

		String dateofbirth = request.getParameter("dateofbirth");

		if (!dateofbirth.equals("")) {
			DateToWords num = new DateToWords();
			String count = dateofbirth;
			System.out.println(count);
			dateofbirth = "   DATEOFBIRTH = \'" + dateofbirth.substring(8) + "-" + dateofbirth.substring(5, 7) + "-"
					+ dateofbirth.substring(0, 4) + "\'";
			this.update(dateofbirth);

			String dateofbirthinwords = "  DATEOFBIRTHINWORDS = \'"
					+ num.convert((Integer.parseInt(count.substring(8)))) + " - "
					+ num.convert((Integer.parseInt(count.substring(5, 7)))) + " - "
					+ num.convert((Integer.parseInt(count.substring(0, 4)))) + "\'";
			this.update(dateofbirthinwords);
			System.out.println(dateofbirthinwords);

		}

		String Group = request.getParameter("Group");

		System.out.println(Group);
		if (!Group.equals("")) {
			Group = "  SGROUP = " + "\'" + Group + "\'";
			this.update(Group);
			System.out.println(Group);
		}

		String Medium = request.getParameter("Medium");

		if (!Medium.equals("")) {
			Medium = "  MEDIUM = " + "\'" + Medium + "\'";
			this.update(Medium);
			System.out.println(Medium);
		}

		String secSubject = request.getParameter("subject");

		if (!secSubject.equals("")) {
			secSubject = "  SECONDSUB = " + "\'" + secSubject + "\'";
			this.update(secSubject);
			System.out.println(secSubject);
		}

		String specilization1 = request.getParameter("specilization1");

		if (!specilization1.equals("")) {
			specilization1 = "  MAINSUB1 = " + "\'" + specilization1 + "\'";
			this.update(specilization1);
			System.out.println(specilization1);
		}

		String specilization2 = request.getParameter("specilization2");

		if (!specilization2.equals("")) {
			specilization2 = "  MAINSUB2 = " + "\'" + specilization2 + "\'";
			this.update(specilization2);
			System.out.println(specilization2);
		}

		String specilization3 = request.getParameter("specilization3");

		if (!specilization3.equals("")) {
			specilization3 = "  MAINSUB3 = " + "\'" + specilization3 + "\'";
			this.update(specilization3);
			System.out.println(specilization3);
		}

		String duefees = request.getParameter("duefees");

		if (!duefees.equals("")) {
			duefees = "  DUE = " + "\'" + duefees + "\'";
			this.update(duefees);
			System.out.println(duefees);
		}

		String year1 = request.getParameter("year");
		if (!year1.equals("")) {
			year1 = "  YEAR = " + year1 + "";
			this.update(year1);
			System.out.println(year1);
		}

		String stye = request.getParameter("syear");
		if (!stye.equals("")) {
			stye = "  SYEAR = " + year1 + "";
			this.update(stye);
			System.out.println(stye);
		}

		String dateofadmission = request.getParameter("dateofadmission");
		if (!dateofadmission.equals("")) {
			String count = dateofadmission;
			dateofadmission = " DATEOFADMISSION = \'" + dateofadmission.substring(8) + "-"
					+ dateofadmission.substring(5, 7) + "-" + dateofadmission.substring(0, 4) + "\'";
			this.update(dateofadmission);
			System.out.println(dateofadmission);

			DateToWords num = new DateToWords();
			String dateofadmissioninwords = "   DATEOFADMISSONINWORDS = \'"
					+ num.convert((Integer.parseInt(count.substring(8)))) + "-"
					+ num.convert((Integer.parseInt(count.substring(5, 7)))) + "-"
					+ num.convert((Integer.parseInt(count.substring(0, 4)))) + "\'";
			this.update(dateofadmissioninwords);
			System.out.println(dateofadmissioninwords);

		}
		
		   
		RequestDispatcher rd=request.getRequestDispatcher("Editstudnet.jsp");
		rd.include(request, response);

	}// end of service method

	private void update(String s) {
		try {

			countforcoupates++;
			System.out.println("Eneter in update method " + s);

			ps = con.prepareStatement("UPDATE TC SET " + s.toUpperCase() + " where ADMNO =" + number + "");
			int x = ps.executeUpdate();
			if (x > 0)
				System.out.println("sucess");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}