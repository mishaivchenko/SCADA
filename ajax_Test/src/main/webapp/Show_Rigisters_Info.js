function show_Info() {
    function Device(name, value) {
        this.name = name;
        this.value = value;
    }

    window.my_array = [];
    var Devices = [] < Device > (5);
    var values = [];
    var names = [];

    $.ajax({
        url: 'show_info',
        success: function (responseText) {
            if (responseText !== "") {


                var Listobject = JSON.parse(responseText);
                Devices = JSON.parse(responseText);


                var html = '<div class="row justify-content-md-center">' + '<table class="table table-bordered" >' + '<thead>';

                html += '<tr><th scope="col">Param name</th>' + '<th scope="col">Value</th> </tr> </thead>';

                for (var i in Devices) {
                    html += '<tr><td>' + Devices[i]['name'] + '</td>' + '<td>' + Devices[i]['value'] + '</td></tr>';
                    values.push(Number.parseFloat(Devices[i]['value']));
                    names.push(Devices[i]['name']);
                }
                html += '</table>' + '</div>';
                div = document.getElementById("MyFuckingMap3");
                div.innerHTML = html;
            } else {
               show_Info();
            }
        }
    });
}