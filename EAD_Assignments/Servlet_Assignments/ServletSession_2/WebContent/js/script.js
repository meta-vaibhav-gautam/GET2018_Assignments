function toggleProfilePictureUpdate() {
    var x = document.getElementById("uploadProfilePictureButton");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}

function toggleProfileDetailUpdateDIV() {
    var updateProfileDetailsDIV = document.getElementById("updateProfileDetailsDIV");
    var profileDetailsDIV = document.getElementById("profileDetailsDIV");
    if (updateProfileDetailsDIV.style.display === "none") {
    	updateProfileDetailsDIV.style.display = "block";
    	profileDetailsDIV.style.display= "none";
    } else {
    	updateProfileDetailsDIV.style.display = "none";
    	profileDetailsDIV.style.display= "block";
    }
}
