


//var MONTHS = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
var step = [];
for(var i=0;i<100;i++){
    step[i] = i;
}
window.values_to_chart = [];

Add_into_Array(window.values);

var config = {
    type: 'line',
    data: {
        labels: step,
        datasets: [{
            label: 'My First dataset',
            data: window.values_to_chart,
            //fill: false,
        },

        ]
    },
    /*options: {
        responsive: true,
        title: {
            display: true,
            text: 'Chart.js Line Chart'
        },
        tooltips: {
            mode: 'index',
            intersect: false,
        },
        hover: {
            mode: 'nearest',
            intersect: true
        },
        scales: {
            xAxes: [{
                display: true,
                scaleLabel: {
                    display: true,
                    labelString: 'Month'
                }
            }],
            yAxes: [{
                display: true,
                scaleLabel: {
                    display: true,
                    labelString: 'Value'
                }
            }]
        }
    }*/
};
function Add_into_Array(need_value) {
    values_to_chart.push(Number(need_value));
}

function func() {
    var ctx = document.getElementById('myChart').getContext('2d');
    window.myLine = new Chart(ctx,config);

if(config.data.datasets.length<100) {
   // add_value(window.values)
    setInterval(add_value(window.values),1000);

}
}

function add_value(need_value ) {
    if(config.data.datasets.length > 0){
        window.myLine.data.datasets.forEach((dataset) => {
            dataset.data.push(need_value);
        });

        window.myLine.update();
    }

}
