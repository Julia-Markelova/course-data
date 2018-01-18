$(function () {


    $("#submitButton").click( function () {
        var email = $("#eMail").val();
        if(ValidateEmail()){
       $.ajax({
            async: false,
            url : '/checkPassword',
            data: {
                "e-mail": email
            },
            error : function(data) {
                $('#usedEMail').val("No user with such E-mail!");
                var errorMessage  = document.getElementById("usedEMail");
                errorMessage.setAttribute("style","color:red");
            },
            success : function (data) {
              //  document.getElementById("submitButton").setAttribute("type", "submit");
               $.ajax({
                   async: false,
                   url : '/resetPasswort',
                   data: {
                       "e-mail": email
                   },
                   error : function(data) {
                       $('#usedEMail').val("some shit happened!please try again");
                       errorMessage.setAttribute("style","color:red");
                   },
                   success : function (data) {
                       document.getElementById("submitButton").setAttribute("disabled","true");
                       var div = document.createElement("div");
                       div.setAttribute("class","group");
                       var label=document.createElement("label");
                       label.innerHTML="input code from message sent to E-mail";
                       label.setAttribute("for","usersCode");
                       label.setAttribute("class","label");
                       var input=document.createElement("input");
                       input.setAttribute("id","usersCode");
                       input.setAttribute("name","usersCode");
                       input.setAttribute("class","input");
                       input.setAttribute("required","true");
                       input.setAttribute("type","number");
                       var button = document.createElement("input");
                       button.className="button";
                       button.setAttribute("value","confirm");
                       button.setAttribute("id","button");
                       button.setAttribute("type","submit");
                       var hr=document.createElement("div");
                       hr.className="hr";
                       var output=document.createElement("output");
                       output.setAttribute("id","error");
                       output.setAttribute("style","color:red");
                       div.appendChild(hr);
                       div.appendChild(input);
                       div.appendChild(label);
                       var div1 = document.createElement("div");
                       div1.setAttribute("class","group");
                       div1.appendChild(button);
                       div1.appendChild(output);
                       document.getElementById("1").appendChild(div);
                       document.getElementById("1").appendChild(div1);
                      /* $("#button").click(function () {
                           var usersCode=$("#usersCode").val();
                           $.ajax({
                               async: false,
                               url: "/resetPassword/confirm",
                               data: {
                                   "e-mail" : email,
                                   "usersCode" :usersCode
                               },
                               error: function(data) {
                                   $('#error').val("Invalid code!");
                                    },
                               success: function(data) {
                              // window.location="privateAccount.html"
                                   }
                           })
                       })*/
                   }
               })
            }
        }); }
    });
});

/**
 * @return {boolean}
 */
function ValidateEmail() {
    var email=document.getElementById("eMail").value;
    var regex =/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (!regex.test(email))
    {
        document.getElementById("incorrectEMail").setAttribute("style", "color:red");
        return false;
    }
    return true;
}

function noErrorName() {
    document.getElementById("incorrectEMail").setAttribute("style", "color:transparent");
    document.getElementById("usedEMail").setAttribute("style", "color:transparent");
}

