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
		%>
		<div align="right">
			<table>
				<tr>
					<td>
						<a href="#"><img src="<%=user.getImage()%>" width="70px" onclick="toggleProfilePictureUpdate()"/></a>
						<strong>HI <%=user.getFirstName().toUpperCase() %> !</strong>
						<div id="uploadProfilePictureButton" style="display:none;">
							<form action="UpdateProfilePicture">
								<input type="file" name="profilePicture" value="Choose picture" accept="image/jpeg, image/jpg, image/png">
								<button onclick="submit()">Upload</button>
							</form>
						</div>
					</td>
					<td align="right" style="display:  block;margin-top: 12px;margin-bottom:  12px;margin-right:  10px;">
						<a href="UserFriends.jsp" id="subLink">Friends</a>
					</td>
				</tr>
			</table>
		</div>
		
		<div id="userProfileDIV">
			<div align="center" id="profileDetailsDIV" style="display:block;">
			<h2>Profile Details</h2>
			<form>
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
						<td><input type="button" value="Edit Profile" onclick="toggleProfileDetailUpdateDIV()"></td>
					</tr>
				</table>
			</form>
			</div>
		
		<div align="center" id="updateProfileDetailsDIV" style="display:none;">
			<h2>Update Profile Details</h2>
			<form action = "UpdateUserDetails">
				<table>
					<tr>
						<td>First Name</td>
						<td><input type="text" value=<%=user.getFirstName() %> name="firstName" id="firstName" required></td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td><input type="text" value=<%=user.getLastName() %> name="lastName" id="lastName" required></td>
					</tr>
					<tr>
						<td>Age</td>
						<td><input type="text" value=<%=user.getAge() %> name="age" id="age" required></td>
					</tr>
					<tr>
						<td>Date Of Birth</td>
						<td><input type="date" value=<%=user.getBirthday() %> name="birthday" id="birthday" required></td>
					</tr>
					<tr>
						<td>Mobile</td>
						<td><input type="text" value=<%=user.getContact() %> name="contact" id="contact" required></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="email" value=<%=user.getEmail() %> name="email" id="email" readonly="readonly"></td>
					</tr>
					<tr>
						<td>Organization</td>
						<td>
							<select name="organization">
								<option value="Metacube">Metacube</option>
								<option value="Google">Google</option>
								<option value="Amazon">Amazon</option>
								<option value="Facebook">Facebook</option>
								<option value="Apple">Apple</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><input type="submit" value="Update"></td>
						<td><input type="button" value="Cancel" onclick="toggleProfileDetailUpdateDIV()"></td>
					</tr>
				</table>
			</form>
			</div>
		</div>
		<hr/>
		<div align="center">
			&copy; Copyright 2018-19 | All Rights reserved. | Metacube Training
		</div>
	</body>
</html>