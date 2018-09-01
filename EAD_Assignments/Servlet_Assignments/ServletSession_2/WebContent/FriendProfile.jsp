<!DOCTYPE html>
<%@page import="java.util.List"%>
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
		<jsp:useBean id="userFacade" class="com.metacube.session_2_Assignment.facade.UserFacade"/>
		<%
			String email = session.getAttribute("email").toString();
			User user = userFacade.getUserDetailsByEmail(email);
			String name = request.getParameter("firstName")+" "+request.getParameter("lastName");
			String friendEmail = request.getParameter("email");
			String contact = request.getParameter("contact");
			String birthday = request.getParameter("birthday");
		%>
		<div align="right">
			<table>
				<tr>
					<td>
						<a href="#"><img src="<%=user.getImage()%>" width="70px" onclick="toggleProfilePictureUpdate()"/></a>
						<strong>HI <%=user.getFirstName().toUpperCase() %> !</strong>
						<div id="uploadProfilePictureButton" style="display:none;">
							<form action="UpdateProfilePicture">
								<input type="file" name="profilePicture" value="upload picture" accept="image/jpeg, image/jpg, image/png">
								<button onclick="submit()">Upload</button>
							</form>
						</div>
					</td>
				</tr>
			</table>
		</div>
		
		<div align="center" id="profileDetailsDIV" style="display:block;">
			<h2><%=name.toUpperCase()+"'s" %> PROFILE</h2>
			<form>
				<table>
					<tr>
						<td>Date Of Birth </td>
						<td><%=birthday%></td>
					</tr>
					<tr>
						<td>Email </td>
						<td><%=friendEmail%></td>
					</tr>
					<tr>
						<td>Contact </td>
						<td><%=user.getContact()%></td>
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