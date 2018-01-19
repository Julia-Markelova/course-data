/**
 * Created by ymark on 17.01.2018.
 */

function update() {
    $.ajax({
        url: "/findAnimal",
        data: {continent:document.getElementById("continent").value},
        success: function (data) {
            clear();
            if(data.length>0) {
                data.forEach(function (t) {
                    draw(t);
                })
            }
            else document.getElementById("main").innerHTML= "Ничего не найдено по запросу";
        },
        dataType: "json"
    });
}


function draw(t) {
    var mainDiv = document.getElementById("main");
    var form = document.createElement("form");
    var innerDiv = document.createElement("div");
    innerDiv.setAttribute("class", "w3-quarter w3-margin-bottom");
    var innerDiv1 = document.createElement("div");
    innerDiv1.setAttribute("class", "w3-card w3-white w3-hover-opacity");
    var img = document.createElement("img");
    img.setAttribute("style", "width:100%; height:200px");
    img.setAttribute("src",t.image);
    var div2 = document.createElement("div");
    div2.setAttribute("class", "w3-container");
    var h3 = document.createElement("h3");
    h3.innerHTML = t.animalName;
    h3.setAttribute("id","animal");
    var li2 = document.createElement("li");
    li2.setAttribute("class", "w3-padding-16");
    li2.innerHTML ="Тип питания: ";
    var b1 = document.createElement("b");
    b1.innerHTML = t.foodType;
    li2.appendChild(b1);
    var li3 = document.createElement("li");
    li3.setAttribute("class", "w3-padding-16");
    li3.innerHTML ="Среда обитания: ";
    var b2 = document.createElement("b");
    b2.innerHTML = t.areal;
    li3.appendChild(b2);
    form.setAttribute("action", "/moreInfo");
    var hidden = document.createElement("input");
    hidden.setAttribute("type","hidden");
    hidden.setAttribute("name","id");
    hidden.setAttribute("value",t.animalName);
    hidden.setAttribute("id","id");
    var button = document.createElement("button");
    button.setAttribute("class", "w3-button w3-teal w3-padding-large");
    button.setAttribute("type","button");
    button.setAttribute("onclick","wiki()");
    button.innerHTML = "Подробнее";
    form.appendChild(button);
    form.appendChild(hidden);
    div2.appendChild(h3);
    div2.appendChild(li2);
    div2.appendChild(li3);
    div2.appendChild(form);
    innerDiv1.appendChild(img);
    innerDiv1.appendChild(div2);
    innerDiv.appendChild(innerDiv1);
    mainDiv.appendChild(innerDiv);
}

function clear() {
    var mainDiv = document.getElementById("main");
    while (mainDiv.firstChild) {
        mainDiv.removeChild(mainDiv.firstChild);
    }
}


function wiki() {
    var href = document.getElementById("id").value;
    window.open("https://ru.wikipedia.org/wiki/"+href);
}

/**
 * Created by ymark on 19.01.2018.
 */
