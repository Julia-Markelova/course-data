/**
 * Created by ymark on 13.12.2017.
 */
/*
 $(function () {

 $("#submitButton").click( function () {
 var email = $("#AeMail").val();
 var password=$("#Apassword").val();
 if (ValidateEmail()){
 $.ajax({
 async: false,
 url : '/authorizeUser',
 data: {
 "e-mail": email,
 "password": password
 },
 error : function(data) {
 $('#error').val("Invalid E-mail or password! Try again...");
 document.getElementById("error").setAttribute("style", "color:red");
 },
 success : function (data) {
 window.location="privateAccount.html"
 }
 }); }
 });
 });
 */

function validate() {
    var i = 0;
    var email = document.getElementById("AeMail").value;
    if (email.length != 0)
        i++;
    else
        document.getElementById("AincorrectEMail").setAttribute("style", "color:red");
    var password = document.getElementById("Apassword").value;
    if (password.length != 0)
        i++;
    else
        document.getElementById("AincorrectPassword").setAttribute("style", "color:red");
    if (i === 2)
        document.getElementById("AsubmitButton").setAttribute("type", "submit");
}


function checkInput() {
    var i = 0;
    var email = document.getElementById("AeMail").value;
    var regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (regex.test(email))
        i++;
    else
        document.getElementById("AincorrectEMail").setAttribute("style", "color:red");
    var password = $("#Apassword").val();
    if (password)
        i++;
    else
        document.getElementById("AincorrectPassword").setAttribute("style", "color:red");
    if (i === 2)
        document.getElementById("AsubmitButton").setAttribute("type", "submit");
}

function noErrorName() {
    document.getElementById("AincorrectEMail").setAttribute("style", "color:transparent");
    document.getElementById("error").setAttribute("style", "color:transparent");
}

function noErrorPassword() {
    document.getElementById("AincorrectPassword").setAttribute("style", "color:transparent");
    document.getElementById("error").setAttribute("style", "color:transparent");
}

$(function () {
        if (location.search === "?error") {
            $("#error").text("Неверный логин или пароль");
        }
    }
);