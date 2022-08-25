<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">

<title>study&conduct</title>
<link rel="stylesheet" href="study.css">
<link rel="stylesheet" href="study.css" media="print">
</head>
<body>

	<%!ResultSet res=null; %>
	<% res=(ResultSet)application.getAttribute("print");
 
%>


	<table>

		<thead>
			<th class="img"><img alt="logo" src="ttd.jpg" width="100"
				height="100"></th>
			<th colspan="2">
				<p class="p1om">OM NAMO VENKATESAYA</p>
				<p class="p2ttd">Tirumala Tirupati Devasthanams</p>
				<p class="p3svarts">SRI VENKATESWARA ARTS COLLEGE, TIRUPATI.</p>
				<p class="p4aff">AFFLIATED TO SRI VENKATESWARA UNIVERSITY</p>
				<p class="p5tc">CONDUCT CERTIFICATE</p>
			</th>
			<th><img alt="logo" src="logo.jpg" width="100" height="100"></th>
		</thead>
	</table>


	<table class="conduct">
		<tr>
			<td colspan="1.5" id="tcno">T.C.No:</td>
			<td colspan="1.5" id="adnos">Admission No: <%out.println("  "+res.getString(1));%>
			</td>
		</tr>

		<tr>
			<td class="title" colspan="1">Name of the Pupil</td>
			<td class="content" colspan="2">: <% out.println("  "+res.getString(3)+"  "+res.getString(2));%></td>
		</tr>

		<tr>
			<td class="title" colspan="1">Class of Study</td>
			<td class="content" colspan="2">: <%out.println("  "+res.getString(18)+" ("+res.getString(12)+"-"+res.getString(13)+"-"+res.getString(14)+")");%></td>
		</tr>

		<tr>
			<td class="title" colspan="1">Period of Study</td>

			<td class="content" colspan="2">: <%out.println("  "+res.getString(19)+"-"+res.getString(17));
			%></td>
		</tr>

		<tr>
			<td class="title" colspan="1">Conduct</td>

			<td class="content" colspan="2">: STISFACTORY</td>
		</tr>

		<tr>
			<td colspan="1.5" id="date">Date:</td>
			<td colspan="1.5" id="signs">Principal</td>
		</tr>
	</table>


	<div class="studycer">
		<table>
			<thead>
				<th class="img"><img alt="logo" src="ttd.jpg" width="100"
					height="100"></th>
				<th colspan="3">
					<p class="p1om">OM NAMO VENKATESAYA</p>
					<p class="p2ttd">Tirumala Tirupati Devasthanams</p>
					<p class="p3svarts">SRI VENKATESWARA ARTS COLLEGE, TIRUPATI.</p>
					<p class="p4aff">AFFLIATED TO SRI VENKATESWARA UNIVERSITY</p>
					<p class="p5tc">STUDY CERTIFICATE</p>
				</th>
				<th><img alt="logo" src="logo.jpg" width="100" height="100"></th>
			</thead>
		</table>



		<table class="certificate">
			<tr>
				<td colspan="1.5" id="tcno">T.C.No:</td>
				<td colspan="1.5" id="adno">Admission No: <% 
			 out.println(res.getString(1));
			%></td>
			</tr>
			<tr>
				<td colspan="3" id="content"><p class="paraforstudy">
						This is to certify that SRI <span class="dataofstd"> <% 
			 out.println(res.getString(3)+"  "+res.getString(2));
			%></span> is /was a student of college, who studied / is studying <span
							class="dataofstd"> <% 
			 out.println(res.getString(18)+" ("+res.getString(12)+"-"+res.getString(13)+"-"+res.getString(14)+")");
			%>
						</span>Course during the academic year <span class="dataofstd">
							<% 
			 out.println(res.getString(19)+"-"+res.getString(17));
			%>
						</span>.
					</p></td>
			<tr>
				<td colspan="1.5" id="date">Date:</td>
				<td colspan="1.5" id="signs">Principal</td>
			</tr>
		</table>
	</div>

	<div class="printbutton">
		<button onclick="window.print();" class="dontPrint">Print</button>
</body>
</html>
