<!DOCTYPE html>
<%@page import="com.metacube.session_2_Assignment.model.User"%>
<html>
	<title>
		Profile	
	</title>
	<head>
		<link rel="Stylesheet" href="css/style.css">
		<script src="js/script.js" type="text/javascript"></script>
	</head>
	<header>
		<div  class="title">
			<span class="image">
				<a href="index.html"><img src="images/MetaCube-Logo.jpg" width=150px/></a>
			</span>
			<span class="link">
				<a href="InvalidateSession">Logout</a>
			</span>
		</div>
	</header>
	<body>	
		<jsp:useBean id="getUserDetails" class="com.metacube.session_2_Assignment.facade.UserFacade"/>
		<%
			String email = session.getAttribute("email").toString();
			User user = getUserDetails.getUserDetailsByEmail(email);
		%>
		<div align="right">
			<table>
				<tr>
					<td>
						<a href="#"><img src="<%=user.getImage()%>" width="70px" onclick="toggleProfilePictureUpdate()"/></a>
						<strong>HI <%=user.getFirstName().toUpperCase() %> !</strong>
						<div id="uploadProfilePictureButton" style="display:none;">
							<input type="file" value="upload picture">
						</div>
					</td>
					<td align="right" style="display:  block;margin-top: 12px;margin-bottom:  12px;margin-right:  10px;">
						<a href="#" id="subLink">Friends</a>
					</td>
				</tr>
			</table>
		</div>
		
		<div align="center">
			<h2>Profile Details</h2>
			<form action = "UpdateProfileDetails">
				<table>
					<tr>
						<td>Name </td>
						<td><%=user.getFirstName()+" "+user.getLastName()%></td>
					</tr>
					<tr>
						<td>Date Of Birth </td>
						<td><%=user.getBirthday()%></td>
					</tr>
					<tr>
						<td>Age </td>
						<td><%=user.getAge()%></td>
					</tr>
					<tr>
						<td>Organization </td>
						<td><%=user.getOrganization()%></td>
					</tr>
					<tr>
						<td>Contact </td>
						<td><%=user.getContact()%></td>
					</tr>
					<tr>
						<td><input type="submit" value="Edit Profile"></td>
					</tr>
				</table>
			</form>
		</div>
		<hr/>
		<div align="center">
			&copy; Copyright 2018-19 | All Rights reserved. | Metacube Training
		</div>
	</body>
</html>