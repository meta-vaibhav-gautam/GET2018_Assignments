function createShapes() {
    drawCircle();
    drawCircleWithSemicircle();
    drawCascadeCircles();
    drawCircleWithCross();
    drawTriangle();
    drawRectangle();
}

function drawCircle() {
    var myCanvas = document.getElementById("shape-container");
    var context = myCanvas.getContext("2d");

    context.fillStyle = "#3193D1";
    context.beginPath();
    context.arc(50, 50, 40, 0, 2 * Math.PI);
    context.fill();
}

function drawCircleWithSemicircle() {
    var myCanvas = document.getElementById("shape-container");
    var context = myCanvas.getContext("2d");

    context.fillStyle = "#3193D1";
    context.beginPath();
    context.arc(250, 50, 40, 0.5 * Math.PI, 1.5 * Math.PI);
    context.fill();

    context.fillStyle = "white";
    context.strokeStyle = "grey";
    context.lineWidth = 5;
    context.beginPath();
    context.arc(250, 50, 37.5, 0.5 * Math.PI, 1.5 * Math.PI, new Boolean(false));
    context.fill();
    context.stroke();
}

function drawCascadeCircles() {
    var myCanvas = document.getElementById("shape-container");
    var context = myCanvas.getContext("2d");

    context.strokeStyle = "blue";
    context.lineWidth = 10;
    context.beginPath();
    context.arc(450, 50, 35, 0, 2 * Math.PI);
    context.fill();
    context.stroke();
}

function drawCircleWithCross() {
    var myCanvas = document.getElementById("shape-container");
    var context = myCanvas.getContext("2d");

    context.fillStyle = "orange";
    context.beginPath();
    context.arc(50, 200, 40, 0, 2 * Math.PI);
    context.fill();

    context.fillStyle = "white";
    context.fillRect(40, 175, 18, 48);
    context.fillRect(20, 190, 60, 18);
}

function drawTriangle() {
    var myCanvas = document.getElementById("shape-container");
    var context = myCanvas.getContext("2d");

    context.fillStyle = "red";
    context.beginPath();
    context.moveTo(200, 250);
    context.lineTo(250, 150);
    context.lineTo(300, 250);
    context.closePath();
    context.fill();
}

function drawRectangle() {
    var myCanvas = document.getElementById("shape-container");
    var context = myCanvas.getContext("2d");

    context.fillStyle = "green";
    context.fillRect(400,150,100,100);
}