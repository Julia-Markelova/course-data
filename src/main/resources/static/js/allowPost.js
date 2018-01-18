/**
 * Created by ymark on 18.01.2018.
 */
/**
 * Created by ymark on 17.01.2018.
 */


$(function () {
    update("/developerAllow");
});

function update(url) {
    $.ajax({
        url: url,
        data: {theme: document.getElementById("value").value},
        success: function (data) {
            clear();
            if(data.length>0) {
                data.forEach(function (t) {
                    draw(t);
                })
            }
            else document.getElementById("theme").innerHTML= "Нет новых публикаций";
        },
        dataType: "json"
    });
}

function allow() {
    $.ajax({
        url: "/allow",
        data: {id: document.getElementById("id").value},
        dataType: 'text',
        success: function(){document.getElementById("li5").innerHTML="Запись опубликована";},
        error:function(){document.getElementById("li5").innerHTML="Ошибка!";}
    })
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
    li2.innerHTML ="Что это? ";
    var b1 = document.createElement("b");
    b1.innerHTML = t.type;
    li2.appendChild(b1);
    var li3 = document.createElement("li");
    li3.setAttribute("class", "w3-padding-16");
    li3.innerHTML ="Автор: ";
    var b2 = document.createElement("b");
    b2.innerHTML = t.user.userName + " " + t.user.userLastName;
    li3.appendChild(b2);
    var li4 = document.createElement("li");
    li4.setAttribute("class", "w3-padding-16");
    li4.innerHTML ="О чем это? ";
    var b3 = document.createElement("b");
    b3.innerHTML =  t.title;
    li4.appendChild(b3);
    var li5 = document.createElement("li");
    li5.setAttribute("class", "w3-theme-l5 w3-padding-24");
    form.setAttribute("action", "/postPage");
    var hidden = document.createElement("input");
    hidden.setAttribute("type","hidden");
    hidden.setAttribute("name","id");
    hidden.setAttribute("id","id");
    hidden.setAttribute("value",t.id);
    var button = document.createElement("button");
    button.setAttribute("class", "w3-button w3-teal w3-padding-large");
    button.setAttribute("type","submit");
    button.innerHTML="Подробнее";
    var li6 = document.createElement("li");
    li6.setAttribute("class", "w3-theme-l5 w3-padding-24");
    li6.setAttribute("id","li5");
    var button1 = document.createElement("button");
    button1.setAttribute("class", "w3-button w3-teal w3-padding-large");
    button1.setAttribute("type","button");
    button1.setAttribute("onclick","allow()");
    button1.innerHTML = "Опубликовать";
    form.appendChild(button);
    form.appendChild(hidden);
    li5.appendChild(form);
    li6.appendChild(button1);
    ul.appendChild(li1);
    ul.appendChild(li2);
    ul.appendChild(li3);
    ul.appendChild(li4);
    ul.appendChild(li5);
    ul.appendChild(li6);
    innerDiv.appendChild(ul);
    mainDiv.appendChild(innerDiv);
}

function clear() {
    var mainDiv = document.getElementById("theme");
    while (mainDiv.firstChild) {
        mainDiv.removeChild(mainDiv.firstChild);
    }
}





/**
 * Created by ymark on 18.01.2018.
 */
