function show_Words() {
    function Device(name, value) {
        this.name = name;
        this.value = value;
    }

    window.my_array = [];
    var Devices = [] < Device > (5);
    var values = [];
    var names = [];

    $.ajax({
        url: 'show_words',
        success: function (responseText) {
            var Listobject = JSON.parse(responseText);
            Devices = JSON.parse(responseText);


            var html = '<div class="row justify-content-md-center">' + '<table class="table col-md-6 " >' + '<thead class="thead-light" >';

            html += '<tr><th scope="col">Param name</th>' + '<th scope="col">Value</th> </tr> </thead>';

            for (var i in Devices) {
                html += '<tr><td>' + Devices[i]['name'] + '</td>' + '<td>' + Devices[i]['value'] + '</td></tr>';
                values.push(Number.parseFloat(Devices[i]['value']));
                names.push(Devices[i]['name']);
            }
            html += '</table>' + '</div>';

            /*   window.values = Number(Devices[0]['value']);


               ;*/

            /* window.myValue = Number(Devices[0]['value']);*/
            div = document.getElementById("MyFuckingMap2");
            div.innerHTML = html;
            setTimeout(2000, show_Words());

        }
    });

}