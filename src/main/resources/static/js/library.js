$(function () {
    $("#search").click(
        function send() {
            $.ajax({
                url: "/findBooks",
                type: "POST",
                data: {
                    min:$("#minPrice").val(),
                    max:$("#maxPrice").val(),
                    era: $('input[name=era]:checked', '#myForm') ? $('input[name=era]:checked', '#myForm').val():"",
                    name: $("#authorLastName").val(),
                    book: $("#edition").val()
                },
                dataType: 'json',
                success: function (jq) {
                    var table = document.getElementById('tbody');
                    var rowCount = table.rows.length;
                    for (var i = rowCount-1; i >= 0; i--) {
                        table.deleteRow(i);
                    }
                    if(jq.length===0)
                        $('booksNotFound').val("Нет книг по указанным параметрам!");
                    jq.forEach(function (t) {
                        var table = document.getElementById('tbody');
                        var tr31 = document.createElement('tr'); //создаем еще строку
                        var td31 = document.createElement('td');
                        td31.innerHTML = t.bookName; //создаем столбец
                        var td32 = document.createElement('td');
                        td32.innerHTML = t.author; //создаем еще столбец
                        var td33 = document.createElement('td');
                        td33.innerHTML = t.publishingHouse; //создаем еще столбец
                        var td34 = document.createElement('td');
                        td34.innerHTML = t.price; //создаем еще столбец

                        tr31.appendChild(td31); //кладем в новосозданную строку первый новосозданный столбец
                        tr31.appendChild(td32); //кладем в новосозданную строку второй новосозданный столбец
                        tr31.appendChild(td33);
                        tr31.appendChild(td34);
                        table.appendChild(tr31); //кладем в таблицу новосозданную строку (последней)
                    });

                } ,
                error: function(){
                    var table = document.getElementById('tbody');
                    var rowCount = table.rows.length;
                    for (var i = rowCount-1; i >= 0; i--) {
                        table.deleteRow(i);
                    }
                    $('booksNotFound').val("Нет книг по указанным параметрам!")

                }
            });
        }

    )

});
/**
 * Created by ymark on 17.01.2018.
 */
