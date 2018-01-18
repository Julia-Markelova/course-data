/**
 * Created by ymark on 17.01.2018.
 */


$(function () {
    switch (location.href){
        case "showEvents":
            update(6,"/updateEvents");
            break;
        case "showRead":
            update(6,"/updatePosts");
            break;
        case "showVideo":
            update(6,"/updateVideo");
            break;
        case "showTests":
            update(6,"/updateTests");
            break;
        case "":
            update(6,"/updateNews");
            break;
    }

});

function update(n,url) {
    $.ajax({
        url: url,
        success: function (data) {
            clear();
            data.forEach(function (t, i) {
                while (i < n)
                    draw(t);
            })
        },
        dataType: "json"
    });
}


function draw(t) {
    var mainDiv = document.getElementById("new");
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
    li2.innerHTML = t.type;
    var li3 = document.createElement("li");
    li3.setAttribute("class", "w3-padding-16");
    li3.innerHTML = t.user.userName + " " + t.user.userLastName;
    var li4 = document.createElement("li");
    li4.setAttribute("class", "w3-padding-16");
    li4.innerHTML = t.title;
    var li5 = document.createElement("li");
    li5.setAttribute("class", "w3-theme-l5 w3-padding-24");
    var button = document.createElement("button");
    button.setAttribute("class", "w3-button w3-teal w3-padding-large");
    button.innerHTML = "Подробнее";
    li5.appendChild(button);
    ul.appendChild(li1);
    ul.appendChild(li2);
    ul.appendChild(li3);
    ul.appendChild(li4);
    ul.appendChild(li5);
    innerDiv.appendChild(ul);
    mainDiv.appendChild(innerDiv);
}

function clear() {
    var mainDiv = document.getElementById("new");
    while (mainDiv.firstChild) {
        mainDiv.removeChild(mainDiv.firstChild);
    }
}





