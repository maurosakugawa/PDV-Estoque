window.onload = jsListen;

function jsListen(){
    var barra = document.getElementById("barra");

    barra.addEventListener("mouseover", changeToRed, false);
    barra.addEventListener("mouseout", changeToGrayBarra, false);
}

function changeToRed() {
    barra.setAttribute("style", "color:red;");
}

function changeToGrayBarra() {
    barra.setAttribute("style", "color:gray;");
}
