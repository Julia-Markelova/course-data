/**
 * Created by ymark on 16.12.2017.
 */

$(function () {
    $("#button").click( function () {
        var name=$("#userName").val();
        var lastname=$("#userLastName").val();
        var email=$("#userEmail").val();
        var password=$("#userPassword").val();
        var oldEmail=$("#oldEmail").val();
        if(noEmptyInput())
        {
            $.ajax({
                async: false,
                url : "/changeUser",
                data: {
                    "userName":name,
                    "lastname": lastname,
                    "email":email,
                    "password":password,
                    "oldEmail":oldEmail
                },
                error : function(data) {
                    $('#usedEMail').val("User with such E-mail is already exist");
                    document.getElementById("usedEmail").setAttribute("style","color:red");

                },
                success : function (data) {
                    $('#ok').val("All changes saved!");
                    document.getElementById("ok").setAttribute("style","color:green");
                }
            }); }
    });
});



function noEmptyInput(){
    var name=document.getElementById("userName").value;
    var lastName=document.getElementById("userLastName").value;
    var email=document.getElementById("userEmail").value;
    var password=document.getElementById("userPassword").value;
    var regex =/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if(name===""){
      document.getElementById("incorrectName").setAttribute("style", "color:red");
      return false;
    }
    if(!regex.test(email)){
        document.getElementById("incorrectEmail").setAttribute("style", "color:red");
        return false;
    }
    if(password===""){
        document.getElementById("incorrectPassword").setAttribute("style", "color:red");
        return false;
    }
    return true;
}

function noErrorName() {
    document.getElementById("incorrectName").setAttribute("style", "color:transparent");
}

function noErrorLastName() {
    document.getElementById("incorrectLastName").setAttribute("style", "color:transparent");
}

function noErrorEmail() {
    document.getElementById("incorrectEmail").setAttribute("style", "color:transparent");
    document.getElementById("usedEmail").setAttribute("style", "color:transparent");
}

function noErrorPassword() {
    document.getElementById("incorrectPassword").setAttribute("style", "color:transparent");
}