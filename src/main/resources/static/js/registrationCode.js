/**
 * Created by ymark on 15.12.2017.
 */
/*$(function () {


    $("#submitButton").click( function () {
        var email = $("#userEmail").val();
        var code=$("#code").val();
        {
            $.ajax({
                async: false,
                url : '/addUser/confirm',
                data: {
                    "userEmail": email,
                    "usersCode": code
                },
                error : function(data) {
                    $('#errorCode').val("Invalid code!");
                    document.getElementById("errorCode").setAttribute("style","color:red");

                },
                success : function (data) {
                    window.location="privateAccount.html"
                }
            }); }
    });
});*/

function noError() {
    document.getElementById("errorCode").setAttribute("style","color:transparent");
}