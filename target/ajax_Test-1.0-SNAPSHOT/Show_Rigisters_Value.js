
function show_Value()
{
  function Device(name,value){
      this.name = name;
      this.value = value;
  }

window.my_array = [];
  var Devices = new Array<Device>(5);
  var values = [];
  var names = [];


    $.ajax({
        url:'show_Registers',
        success : function(responseText) {
            var Listobject = JSON.parse(responseText);
            Devices = JSON.parse(responseText);


           var html = '<table border="1" bgcolor="#f0ffff">';

        html+= '<tr> <th>Name</th> <th>Value</th> </tr>';

            for (var i in Devices) {
                html += '<tr><td>' + Devices[i]['name'] + '</td>' + '<td>' + Devices[i]['value'] + '</td></tr>';
                values.push(Number.parseFloat(Devices[i]['value']));
                names.push(Devices[i]['name']);
            }
            html += '</table>';

            window.values = Number(Devices[0]['value']);
            div = document.getElementById("MyFuckingMap");
               // alert(typeof window.value);
            div.innerHTML = html;
            div_name = document.getElementById("names");
            div_name.innerHTML = names;
            div_value = document.getElementById("values");
            div_value.innerHTML = Devices[0]['value'];

           setTimeout(100,show_Value());

        }
    });
//window.values =
}


