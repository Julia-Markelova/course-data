/**
 * Created by ymark on 11.12.2017.
 */
$(function () {


    $("#submitButton").click( function () {
        var email = $("#eMail").val();
        if (ValidateEmail()){
         $.ajax({
            async: false,
            url : '/checkEmail',
            data: {
                "email": email
            },
            error : function(data) {
                $('#existEmail').val("User with such E-mail is already exist!");

            },
            success : function (data) {
                document.getElementById("submitButton").setAttribute("type", "submit");
                $('#registrationForm').submit();
            }
        }); }
    });
});

/**
 * @return {boolean}
 */
function ValidateEmail() {
    var email=document.getElementById("eMail").value;
    var name=$('#userName').val();
    var password=$('#password').val();
    var regex =/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if(name==="") {
        document.getElementById("enterName").setAttribute("style", "color:red");
        return false;
    }
    if (!regex.test(email))
    {
        document.getElementById("incorrectEMail").setAttribute("style", "color:red");
        return false;
    }
    if(password===""){
        document.getElementById("enterPassword").setAttribute("style", "color:red");
        return false;
    }
return true;


}

function noErrorRname() {
    document.getElementById("enterName").setAttribute("style", "color:transparent");
}

function noErrorReMail() {
    document.getElementById("incorrectEMail").setAttribute("style", "color:transparent");
}

function noErrorRpassword() {
    document.getElementById("enterPassword").setAttribute("style", "color:transparent");
}


