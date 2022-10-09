
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Edit Student</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="Editpage.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>


	<%!ResultSet res=null; %>
	<% res=(ResultSet)application.getAttribute("print");
	  
%>
	<div class="container">
		<div class="newstudentpage">

			<h1>Edit The Student Details</h1>
			<form action="editStudentDetails" method="post">

						<input type="hidden" name="number"
							value="<% out.println(res.getString(1)); %>">
				<table>
					
					
					<tr>
						<td class="slno">1</td>
						<td class="documment">Name of the Pupil</td>
						<td class="stinput"><input type="text"
							placeholder="Enter your name" name="nameofst">
							<br><br><span class="output">
						<% out.println(res.getString(2)); %>
						</span>
							</td>
					</tr>
					
					<tr>
						<td></td>
						<td></td>
						<td><input type="text" placeholder="Enter your surname"
							name="surname"> 
							<br><br><span class="output">
						<% out.println(res.getString(3)); %>
						</span>
							</td>
					</tr>

					

					<tr>
						<td class="slno">2</td>
						<td class="documment">Father's Name</td>
						<td class="stinput"><input type="text"
							placeholder="fathername" name="fathername">
							<br><br><span class="output">
						<% out.println(res.getString(4)); %>
						</span></td>

					</tr>

					
					<tr>
						<td></td>
						<td></td>
						<td><input type="text"
							placeholder="Enter your father surname" name="fathersurname">
						
						<br><br><span class="output">
						<% out.println(res.getString(5)); %>
						</span></td>
					</tr>


					

					<tr>
						<td class="slno"">3</td>
						<td class="documment">Nationality/Religion and Caste</td>
						<td class="stinput">: <select name="nationality">
								<option value="" selected="selected">No change</option>
								<option value="Indian">INDIAN</option>
						</select> <select name="Religion">
								<option value="" selected="selected">No change</option>
								<option value="HINDU">HINDU</option>
								<option value="MUSLIM">MUSLIM</option>
								<option value="CHRISTIAN">CHRISTIAN</option>
						</select> <select name="Caste">
								<option value="" selected="selected">No change</option>
								<option value="OC">OC</option>
								<option value="BC-A">BC-A</option>
								<option value="BC-B">BC-B</option>
								<option value="BC-C">BC-C</option>
								<option value="BC-D">BC-D</option>
								<option value="BC-E">BC-E</option>
								<option value="SC">SC</option>
								<option value="ST">ST</option>
						</select>

						</td>
					<tr>
						<td></td>
						<td></td>
						<td><input type="text" name="subrelgion"
							placeholder="SUB RELIGON"> <input type="text"
							name="subcaste" placeholder="SUB CASTE"></td>


					</tr>

					<tr>
						<td></td>
						<td></td>
						<td class="output">
							<% out.println(res.getString(6)); %>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>GENDER</td>
						<td><input type="radio" name="gender" value="male">male
							<br> <input type="radio" name="gender" value="female">female
							<br> <input type="radio" name="gender" value="others">others
					<br>	<br><span class="output">
						<% out.println(res.getString(7)); %>
						</span>
						</td>

					</tr>
					

					<tr>


						<td class="slno">4</td>
						<td class="documment">Date of Birth</td>
						<td class="stinput"><input type="date" name="dateofbirth">
						
						<br><br><span class="output">
						<% out.println(res.getString(8)+"     [ "+res.getString(9)+" ]"); %>
						</span></td>
							
					</tr>

					

					<tr>
						<td class="slno">5</td>
						<td class="documment">
						
						<br> Group</br> 
						<br>Medium</br>
						 <br>Subject
							studided Part-1(B)</br>
							
						 <br>Part-2 (optional) (i)</br>
						  <br>(ii)</br>
						   <br>(iii)</br>
						</td>
						<td class="stinput"><br> <select name="Group"><option
									value="" selected="selected">No change</option>
								<option value="Bcom">BCOM</option>
								<option value="BSC">BSC</option>
								<option value="BA">BA</option>
						</select>
						<span class="output">
						<% out.println(res.getString(18)); %>
						</span>
						</br>
						<br> <select name="Medium">
								<option value="" selected="selected">No change</option>
								<option value="Telugu">TELUGU</option>
								<option value="English">English</option>
								<option value="HINDi">HINDI</option>
						</select>
						<span class="output">
						<% out.println(res.getString(10)); %>
						</span>
						</br> 
						
						<br> <select name="subject">
								<option value="" selected="selected">No change</option>
								<option value="Telugu">TELUGU</option>
								<option value="English">ENGLISH</option>
								<option value="HINDi">HINDI</option>
						</select>
						<span class="output">
						<% out.println(res.getString(11)); %>
						</span>
						</br>
						<br> <input type="text" name="specilization1"
							placeholder="subject name">
							 <span class="output">
						<% out.println(res.getString(12)); %>
						</span></br><br><input
							type="text" name="specilization2" placeholder="subject name">
							<span class="output">
						<% out.println(res.getString(13)); %>
						</span></br><br> <input type="text" name="specilization3"
							placeholder="subject name">
							
							<span class="output">
						<% out.println(res.getString(14)); %>
						</span>
							</td>
					</tr>

					

					<tr>
						<td class="slno">6</td>
						<td class="documment">Date of Admission</td>
						<td class="stinput"><input type="date" name="dateofadmission">
							<br><br> <span class="output">
						<% out.println(res.getString(15)+" [ "+res.getString(20)+" ]"); %>
						</span></td>
					</tr>

					<tr>
						<td class="slno">7</td>
						<td class="documment">Whether the pupil has paid all fees due
							to this college</td>
						<td class="stinput"><select name="duefees"><option
									value="" selected="selected">NO CHANGE</option>
								<option value="Yes">yes</option>
								<option value="No">No</option>
						</select>
						<span class="output">
						<% out.println(res.getString(16)); %>
						</span>
						
						</td>
					</tr>
					
					</tr>
					<tr>
						<td class="slno">8</td>
						<td class="documment">Date of which the pupil has actually
							left the College</td>
						<td class="stinput">: <input type="text"
							placeholder="Enetrjoin year" name="syear"> <input
							type="text" placeholder="Enetr the End year" name="year">
							<br><br><span class="output">
						<% out.println(res.getString(17)); %>
						</span><span class="output">
						<% out.println(res.getString(19)); %>
						</span>
						</td>
					</tr>
					


					<tr>
						<td colspan="3" class="submit"><input type="submit"
							name="newstudentsubmit" value="Submit">
							
						 <span class="buton"><a href="forTc.html">BACK </a></span>	
							
							<span class="buton"><a href="admin.html">MAIN </a></span>	
							
							</td>
					</tr>
				</table>

			</form>


		</div>
	</div>
</body>

</html>