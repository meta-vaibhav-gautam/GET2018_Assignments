function validate() {
	if(validateName() && validateEmail() && validatePassword() && validateContact()) {
		document.getElementById("registrationForm").submit();
	}
}

function validateName() {
	var re = /^[A-Za-z]+$/;
	var firstName=document.getElementById("firstName").value;
	var lastName=document.getElementById("lastName").value;
	if((firstName.length>2 && re.test(firstName))&& (lastName.length>2 && re.test(lastName))) {
		return true;
	} else {
		alert("Invalid Name Entered");
		return false;
	}
}

function validateEmail() {
	var re = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	var email = document.getElementById("email").value;
	if(re.test(email)) {
		return true;
	} else {
		alert("Invalid Email Id");
		return false;
	}
}

function validatePassword() {
	var password = document.getElementById("password").value;
	var confirmPassword = document.getElementById("confirmPassword").value;
	var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
	if(password == confirmPassword) {
		if(re.test(password)) {
			return true;
		} else {
			alert("Inavlid Password entered");
			return false;
		}
	} else {
		alert("Password doesn't matched with confirm password");
	}
}

function validateContact() {
	var contact=document.getElementById("contact").value;
	if(contact.length>8 && (!isNaN(contact))) {
		return true;
	} else {
		alert("Inavlid contact Entered");
		return false;
	}
}
