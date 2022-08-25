<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Transfer Certificate</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' type='text/css' media='print' href='tc.css'>
<link rel='stylesheet' type='text/css' media='screen' href='tc.css'>
</head>
<body>
	<%!ResultSet res=null; %>
	<% res=(ResultSet)application.getAttribute("print");
 
%>



	<table class="headfile">
		<thead>
			<th class="img"><img alt="logo" src="logo.jpg" width="100"
				height="100"></th>
			<th colspan="3">
				<p class="p1om">OM NAMO VENKATESAYA</p>
				<p class="p2ttd">Tirumala Tirupati Devasthanams</p>
				<p class="p3svarts">SRI VENKATESWARA ARTS COLLEGE, TIRUPATI.</p>
				<p class="p4aff">AFFLIATED TO SRI VENKATESWARA UNIVERSITY</p>
				<p class="p5tc">TRANSFER CERTIFICATE</p>
			</th>
		</thead>
	</table>

	<table class="maintable">
		<tr>
			<td colspan="2" id="tc-no"><strong>T.C.No:</strong></td>

			<td colspan="2" id="admi-no"><strong> Admission No: <% 
			 out.println(res.getString(1));
			%>
			</strong></td>
		</tr>
		<tr>
			<td class="sno">1)</td>
			<td class="row-content">Name of the Pupil</td>
			<td>:</td>
			<td class="row-output">
				<% out.println(res.getString(3)+"  "+res.getString(2)); %>
			</td>
		</tr>
		<tr>
			<td class="sno">2)</td>
			<td class="row-content">Father's Name</td>
			<td>:</td>
			<td class="row-output">
				<% out.println(res.getString(5)+" "+res.getString(4)); %>
			</td>
		</tr>

		<tr>
			<td class="sno">3)</td>
			<td class="row-content">Nationality/Religion and Caste</td>
			<td>:</td>
			<td class="row-output">
				<% out.println(res.getString(6)); %>
			</td>
		</tr>

		<tr>
			<td class="sno">4)</td>
			<td class="row-content">Date of Birth</td>
			<td>:</td>
			<td class="row-output">
				<% out.println(res.getDate(8)); %>
			</td>
		</tr>

		<tr>
			<td class="sno"></td>
			<td class="row-content">in words as entered in the Admission
				Register</td>
			<td>:</td>
			<td class="row-output">
				<% out.println(res.getString(9)); %>
			</td>
		</tr>
		<tr>
			<td class="sno">5)</td>
			<td class="row-content">(a) Class in which the pupil was <br>studying
				at the time of leaving

			</td>
			<td>:</td>
			<td class="row-output">
				<% out.println(res.getString(18)); %>
			</td>
		</tr>


		<tr>
			<td class="sno"></td>
			<td class="row-content">(b) Medium</td>
			<td>:</td>
			<td class="row-output">
				<% out.println(res.getString(10)); %>
			</td>
		</tr>
		<tr>
			<td class="sno"></td>
			<td class="row-content">(c) Subject Studied Part -I (B)</td>
			<td>:</td>
			<td class="row-output">
				<% out.println(res.getString(11)); %>
			</td>
		</tr>
		<tr>
			<td class="sno"></td>
			<td class="row-content">Part -II (Optionals) (i)</td>
			<td>:</td>
			<td class="row-output">
				<% out.println(res.getString(12)); %>
			</td>
		</tr>
		<tr>
			<td class="sno"></td>
			<td class="row-content" id="sno">(ii)</td>
			<td>:</td>
			<td class="row-output">
				<% out.println(res.getString(13)); %>
			</td>
		</tr>
		<tr>
			<td class="sno"></td>
			<td class="row-content" id="sno">(iii)</td>
			<td>:</td>
			<td class="row-output">
				<% out.println(res.getString(14)); %>
			</td>
		</tr>



		<tr>
			<td class="sno">6)</td>
			<td class="row-content">Date of Admission</td>
			<td>:</td>
			<td class="row-output"></td>
		</tr>
		<tr>
			<td class="sno"></td>
			<td class="row-content">(Year to be entered in words)</td>
			<td>:</td>
			<td class="row-output">
				<% out.println(res.getDate(15)); %>
			</td>
		</tr>
		<tr>
			<td class="sno">7)</td>
			<td class="row-content">Whether qualified for promotion to a<br>
				Higher Class

			</td>
			<td>:</td>
			<td class="row-output">VIDE GAZETTE</td>
		</tr>

		<tr>
			<td class="sno">8)</td>
			<td class="row-content">Whether the pupil has paid all the <br>
				fee due to this college
			</td>
			<td>:</td>
			<td class="row-output">
				<% out.println(res.getString(16)); %>
			</td>
		</tr>

		<tr>
			<td class="sno">9)</td>
			<td class="row-content">whether the pupil was in receipt of <br>Scholarship
				(Nature of Scholarship to <br>be specified)
			</td>
			<td>:</td>
			<td class="row-output"></td>
		</tr>

		<tr>
			<td class="sno">10)</td>
			<td class="row-content">Whether the pupil has undergone<br>
				Medical Inspection
			</td>
			<td>:</td>
			<td class="row-output"></td>
		</tr>
		<tr>
			<td class="sno">11)</td>
			<td class="row-content">Date on which the pupil has actually<br>
				left the college
			</td>
			<td>:</td>
			<td class="row-output"></td>
		</tr>

		<tr>
			<td class="sno">12)</td>
			<td class="row-content">Date of which application for T.C. was <br>made
				on behalf of the pupil
			</td>
			<td>:</td>
			<td class="row-output">
				<% out.println(res.getString(17)); %>
			</td>
		</tr>

		<tr>
			<td class="sno">13)</td>
			<td class="row-content">Conduct of student during the period <br>of
				his/her study in the College
			</td>
			<td>:</td>
			<td class="row-output">SATISFACTORY</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<div class="certify">
					<% out.print("ORIGINAL"); %>
				</div>

			</td>

		</tr>


		<tr class="last-row">
			<td colspan="2" id="date"><b>Date</b>:<%
            Date date = new Date();
            out.print(" "+date.toLocaleString().substring(0,11)); %></td>
			<td colspan="2" id="sign">Signature of the Principal</td>
		</tr>
	</table>
	<div class="printbutton">
		<button onclick="window.print();" class="dontPrint">Print</button>
	</div>


</body>
</html>