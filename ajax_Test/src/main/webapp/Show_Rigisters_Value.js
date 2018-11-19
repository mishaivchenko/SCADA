function show_Value() {
    function Device(name, value) {
        this.name = name;
        this.value = value;
    }

    window.my_array = [];
    var Devices = new Array < Device > (5);
    var values = [];
    var names = [];


    $.ajax({
        url: 'show_Registers',
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
            window.values = Number(Devices[0]['value']);
            div = document.getElementById("MyFuckingMap");
            div.innerHTML = html;
            window.myValue = Number(Devices[0]['value']);
            setTimeout(300, show_Value());
        }
    });

}


