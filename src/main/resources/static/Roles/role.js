/**
 * Created by ymark on 17.12.2017.
 */
function checkInput(){
    var i=0;
    var ans1 = document.getElementsByName("1");
    var ans2 = document.getElementsByName("2");
    var ans3 = document.getElementsByName("3");
    var ans4 = document.getElementsByName("4");
    var ans5 = document.getElementsByName("5");
    var ans6 = document.getElementsByName("6");
    var ans7 = document.getElementsByName("7");
    var ans8 = document.getElementsByName("8");
    var ans9 = document.getElementsByName("9");
    var ans10 = document.getElementsByName("10");
    var ans11 = document.getElementsByName("11");
    var ans12 = document.getElementsByName("12");
   for(j=0;j<ans1.length;j++) {
       if(ans1[j].checked)
           i++;
       if(ans2[j].checked)
           i++;
       if(ans3[j].checked)
           i++;
       if(ans4[j].checked)
           i++;
       if(ans5[j].checked)
           i++;
       if(ans6[j].checked)
           i++;
       if(ans7[j].checked)
           i++;
       if(ans8[j].checked)
           i++;
       if(ans9[j].checked)
           i++;
       if(ans10[j].checked)
           i++;
       if(ans11[j].checked)
           i++;
       if(ans12[j].checked)
           i++;
    }
    if(i===12){
    document.getElementById("button").setAttribute("type","submit");
        document.getElementById("button").isDisabled=true;}
   else{
       $("#error").val("Необходимо выбрать ответ на все вопросы!");
        return false;

    }
}