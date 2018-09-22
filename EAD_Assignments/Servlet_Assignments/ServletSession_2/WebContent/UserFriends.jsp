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
			List<User> friendList = userFacade.getFriendListOfUser(email, user.getOrganization());
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
			<h2><%=user.getFirstName()+"'s" %> Friends</h2>
			<table>
			<%
				for(User friend : friendList) {
			%>
			<form action="FriendProfile.jsp">
					<tr>
						<td><input type="hidden" value=<%=friend.getFirstName() %> name="firstName" id="firstName" required></td>
					</tr>
					<tr>
						<td><input type="hidden" value=<%=friend.getLastName() %> name="lastName" id="lastName" required></td>
					</tr>
					<tr>
						<td><input type="hidden" value=<%=friend.getAge() %> name="age" id="age" required></td>
					</tr>
					<tr>
						<td><input type="hidden" value=<%=friend.getBirthday() %> name="birthday" id="birthday" required></td>
					</tr>
					<tr>
						<td><input type="hidden" value=<%=friend.getContact() %> name="contact" id="contact" required></td>
					</tr>
					<tr>
						<td><input type="hidden" value=<%=friend.getEmail() %> name="email" id="email" readonly="readonly"></td>
					</tr>
					<tr>
						<td><input type="hidden" value=<%=friend.getOrganization() %> name="organization" id="organization" readonly="readonly"></td>
					</tr>
					<tr>
						<td><img src="<%=friend.getImage()%>" width="50px"/></td>
						<td><%=friend.getFirstName()+" "+friend.getLastName()%></td>
						<td><input type="submit" value="View Profile"></td>
					</tr>
			</form>
			<%
				}
			%>
			</table>
		</div>
		<hr/>
		<div align="center">
			&copy; Copyright 2018-19 | All Rights reserved. | Metacube Training
		</div>
	</body>
</html>