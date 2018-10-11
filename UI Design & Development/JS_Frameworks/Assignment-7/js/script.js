var errorMessages = {};
errorMessages.id = [];
errorMessages.msg = [];
var index = -1;

function addElement() {
    var form = document.getElementById("registration-form");
    var formElementCount = form.getElementsByClassName("form-element-container").length;
    if (formElementCount > 8) {
        var element1 = form.getElementsByClassName("form-element-container")[7];
        var element2 = form.getElementsByClassName("form-element-container")[8];
        form.removeChild(element1);
        form.removeChild(element2);
    }
    var state = document.getElementById("state").value;
    if (state == "Haryana") {
        addZipCodeField();
        addRadioButtonField();
    }
    if (state == "Rajasthan") {
        addWebsiteField();
        addProjectDescriptionField();
    }
    if (state == "Maharashtra") {
        addZipCodeField();
        addProjectDescriptionField();
    }
}

function addWebsiteField() {
    var form = document.getElementById("registration-form");
    var submitButton = document.getElementById("submit-button");
    var parentDiv = document.createElement("div");
    parentDiv.setAttribute("class", "form-element-container");

    var childDiv1 = document.createElement("div");
    childDiv1.setAttribute("class", "element-label");
    var elementLabel = document.createTextNode("Website or domain name");
    childDiv1.appendChild(elementLabel);
    parentDiv.appendChild(childDiv1);

    var childDiv2 = document.createElement("div");
    childDiv2.setAttribute("class", "form-element");
    var iconSpan = document.createElement("span");
    var icon = document.createElement("i");
    icon.setAttribute("class", "fas fa-globe-americas");
    iconSpan.appendChild(icon);
    childDiv2.appendChild(iconSpan);

    var inputDiv = document.createElement("div");
    var websiteField = document.createElement("input");
    websiteField.setAttribute("type", "text");
    websiteField.setAttribute("id", "website");
    websiteField.setAttribute("name", "website");
    websiteField.setAttribute("required", "required");
    websiteField.setAttribute("placeholder", "Enter your website or domain name");
    inputDiv.appendChild(websiteField);
    childDiv2.appendChild(inputDiv);
    parentDiv.appendChild(childDiv2);

    form.insertBefore(parentDiv, submitButton);
}

function addProjectDescriptionField() {
    var form = document.getElementById("registration-form");
    var submitButton = document.getElementById("submit-button");
    var parentDiv = document.createElement("div");
    parentDiv.setAttribute("class", "form-element-container");

    var childDiv1 = document.createElement("div");
    childDiv1.setAttribute("class", "element-label");
    var elementLabel = document.createTextNode("Project Description");
    childDiv1.appendChild(elementLabel);
    parentDiv.appendChild(childDiv1);

    var childDiv2 = document.createElement("div");
    childDiv2.setAttribute("class", "form-element");
    var iconSpan = document.createElement("span");
    var icon = document.createElement("i");
    icon.setAttribute("id", "project-description-icon");
    icon.setAttribute("class", "fas fa-pen");
    iconSpan.appendChild(icon);
    childDiv2.appendChild(iconSpan);

    var textAreaDiv = document.createElement("div");
    var descriptionField = document.createElement("textarea");
    descriptionField.setAttribute("rows", 3);
    descriptionField.setAttribute("cols", 30);
    descriptionField.setAttribute("id", "project-description");
    descriptionField.setAttribute("name", "project-description");
    descriptionField.setAttribute("required", "required");
    descriptionField.setAttribute("placeholder", "Enter Project Description");
    textAreaDiv.appendChild(descriptionField);
    childDiv2.appendChild(textAreaDiv);
    parentDiv.appendChild(childDiv2);

    form.insertBefore(parentDiv, submitButton);
}

function addZipCodeField() {
    var form = document.getElementById("registration-form");
    var submitButton = document.getElementById("submit-button");
    var parentDiv = document.createElement("div");
    parentDiv.setAttribute("class", "form-element-container");

    var childDiv1 = document.createElement("div");
    childDiv1.setAttribute("class", "element-label");
    var elementLabel = document.createTextNode("Zip Code");
    childDiv1.appendChild(elementLabel);
    parentDiv.appendChild(childDiv1);

    var childDiv2 = document.createElement("div");
    childDiv2.setAttribute("class", "form-element");
    var iconSpan = document.createElement("span");
    var icon = document.createElement("i");
    icon.setAttribute("class", "fas fa-home");
    iconSpan.appendChild(icon);
    childDiv2.appendChild(iconSpan);

    var inputDiv = document.createElement("div");
    var zipcodeField = document.createElement("input");
    zipcodeField.setAttribute("type", "text");
    zipcodeField.setAttribute("id", "zipcode");
    zipcodeField.setAttribute("name", "zipcode");
    zipcodeField.setAttribute("required", "required");
    zipcodeField.setAttribute("placeholder", "Enter zipcode");
    inputDiv.appendChild(zipcodeField);
    childDiv2.appendChild(inputDiv);
    parentDiv.appendChild(childDiv2);

    form.insertBefore(parentDiv, submitButton);
}

function addRadioButtonField() {
    var form = document.getElementById("registration-form");
    var submitButton = document.getElementById("submit-button");
    var parentDiv = document.createElement("div");
    parentDiv.setAttribute("class", "form-element-container");

    var childDiv1 = document.createElement("div");
    childDiv1.setAttribute("class", "element-label");
    var elementLabel = document.createTextNode("Do you have hosting ?");
    childDiv1.appendChild(elementLabel);
    parentDiv.appendChild(childDiv1);

    var childDiv2 = document.createElement("div");
    childDiv2.setAttribute("id", "form-radio-button");
    childDiv2.setAttribute("class", "form-element");

    var div1 = document.createElement("div");
    var label1 = document.createElement("label");
    var yesRadioButton = document.createElement("input");
    yesRadioButton.setAttribute("type", "radio");
    yesRadioButton.setAttribute("id", "hosting");
    yesRadioButton.setAttribute("name", "hosting");
    yesRadioButton.setAttribute("value", "yes");
    var yesLabel = document.createTextNode("Yes");
    label1.appendChild(yesRadioButton);
    label1.appendChild(yesLabel);

    var div2 = document.createElement("div");
    var label2 = document.createElement("label");
    var noRadioButton = document.createElement("input");
    noRadioButton.setAttribute("type", "radio");
    noRadioButton.setAttribute("id", "hosting");
    noRadioButton.setAttribute("name", "hosting");
    noRadioButton.setAttribute("value", "no");
    var noLabel = document.createTextNode("No");
    label2.appendChild(noRadioButton);
    label2.appendChild(noLabel);


    div1.appendChild(label1);
    div2.appendChild(label2);
    childDiv2.appendChild(div1);
    childDiv2.appendChild(div2);
    parentDiv.appendChild(childDiv2);

    form.insertBefore(parentDiv, submitButton);
}

function validate() {
    validateName();
    validateEmail();
    validateCity();
    validateState();
    var flag = false;
    if (index > -1) {
        var i;
        var invalidFields = "";
        for (i = 0; i <= index; i++) {
            invalidFields += errorMessages.id[i] + " : " + errorMessages.msg[i] + "\n";
        }
        alert("Please correct the inputs given in following fields:\n\n" + invalidFields);
        index = -1;
    }
    else {
        flag = true;
        document.getElementById("registration-form").submit();
    }
    return flag;
}

function validateName() {
    var re = /^[A-Za-z]+$/;
    var firstName = document.getElementById("first-name").value;
    var lastName = document.getElementById("last-name").value;
    if (!((firstName.length > 2 && re.test(firstName)) && (lastName.length > 2 && re.test(lastName)))) {
        errorMessages.id[++index] = "name";
        errorMessages.msg[index] = "Invalid firstname or lastname entered !";
    }
}

function validateEmail() {
    var re = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    var email = document.getElementById("email").value;
    if (!(re.test(email))) {
        errorMessages.id[++index] = "Email";
        errorMessages.msg[index] = "Invalid email entered !";
    }
}

function validatePhone() {
    var contact = document.getElementById("phone").value;
    if (!(contact.length > 8 && (!isNaN(contact)))) {
        errorMessages.id[++index] = "Phone";
        errorMessages.msg[index] = "Invalid contact entered !";
    }
}

function validateCity() {
    // debugger;
    var re = /^[A-Za-z]+$/;
    var city = document.getElementById("city").value;
    if (!(city.length > 2 && re.test(city))) {
        errorMessages.id[++index] = "City";
        errorMessages.msg[index] = "Invalid city entered !";
    }
}

function validateZipCode() {
    var zipcode = document.getElementById("zipcode").value;
    if (!(zipcode.length == 6 && (!isNaN(zipcode)))) {
        errorMessages.id[++index] = "zipcode";
        errorMessages.msg[index] = "Invalid zipcode entered !";
    }
}

function validateState() {
    var state = document.getElementById("state").value;
    if (state == "") {
        errorMessages.id[++index] = "state";
        errorMessages.msg[index] = "Selection of a state is mandatory !";
    }
}

function getProfileData() {
    var urlString = window.location;
    var url = new URL(urlString);
    var state = url.searchParams.get("state");
    document.getElementById("name").innerHTML = url.searchParams.get("first-name") + " " + url.searchParams.get("last-name");
    document.getElementById("email").innerHTML = url.searchParams.get("email");
    document.getElementById("city").innerHTML = url.searchParams.get("city");
    document.getElementById("phone").innerHTML = url.searchParams.get("phone");
    document.getElementById("address").innerHTML = url.searchParams.get("address");
    document.getElementById("state").innerHTML = state;
    if (state == "Haryana") {
        document.getElementById("label-1").innerHTML = "Zipcode:";
        document.getElementById("label-1-content").innerHTML = url.searchParams.get("zipcode");
        document.getElementById("label-2").innerHTML = "Have Hosting:";
        document.getElementById("label-2-content").innerHTML = url.searchParams.get("hosting");
    }
    if (state == "Rajasthan") {
        document.getElementById("label-1").innerHTML = "Website:";
        document.getElementById("label-1-content").innerHTML = url.searchParams.get("website");
        document.getElementById("label-2").innerHTML = "Project Description:";
        document.getElementById("label-2-content").innerHTML = url.searchParams.get("project-description");
    }
    if (state == "Maharashtra") {
        document.getElementById("label-1").innerHTML = "Zipcode:";
        document.getElementById("label-1-content").innerHTML = url.searchParams.get("zipcode");
        document.getElementById("label-2").innerHTML = "Project Description:";
        document.getElementById("label-2-content").innerHTML = url.searchParams.get("project-description");
    }
}


