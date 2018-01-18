/**
 * Created by ymark on 17.01.2018.
 */


$(function () {
    update("/loadTheme");
});

function update(url) {
    $.ajax({
        url: url,
        data: {theme: document.getElementById("value").value},
        success: function (data) {
            clear();
            data.forEach(function (t) {
                draw(t);
            })

        },
        dataType: "json"
    });
}


function draw(t) {
    var mainDiv = document.getElementById("theme");
    var form = document.createElement("form");
    var innerDiv = document.createElement("div");
    innerDiv.setAttribute("class", "w3-third w3-margin-bottom");
    var ul = document.createElement("ul");
    ul.setAttribute("class", "w3-ul w3-border w3-hover-shadow");
    var li1 = document.createElement("li");
    li1.setAttribute("class", "w3-theme-l2");
    var p = document.createElement("p");
    p.setAttribute("class", "w3-xlarge");
    p.innerHTML = t.theme;
    li1.appendChild(p);
    var li2 = document.createElement("li");
    li2.setAttribute("class", "w3-padding-16");
    li2.innerHTML ="Что это? "+ t.type;
    var li3 = document.createElement("li");
    li3.setAttribute("class", "w3-padding-16");
    li3.innerHTML ="Автор "+ t.user.userName + " " + t.user.userLastName;
    var li4 = document.createElement("li");
    li4.setAttribute("class", "w3-padding-16");
    li4.innerHTML ="О чем это? "+ t.title;
    var li5 = document.createElement("li");
    li5.setAttribute("class", "w3-theme-l5 w3-padding-24");
    form.setAttribute("action", "/postPage");
    var hidden = document.createElement("input");
    hidden.setAttribute("type","hidden");
    hidden.setAttribute("name","id");
    hidden.setAttribute("value",t.id);
    var button = document.createElement("button");
    button.setAttribute("class", "w3-button w3-teal w3-padding-large");
    button.setAttribute("type","submit");
    button.innerHTML = "Подробнее";
    form.appendChild(button);
    form.appendChild(hidden);
    li5.appendChild(form);
    ul.appendChild(li1);
    ul.appendChild(li2);
    ul.appendChild(li3);
    ul.appendChild(li4);
    ul.appendChild(li5);
    innerDiv.appendChild(ul);
    mainDiv.appendChild(innerDiv);
}

function clear() {
    var mainDiv = document.getElementById("theme");
    while (mainDiv.firstChild) {
        mainDiv.removeChild(mainDiv.firstChild);
    }
}





