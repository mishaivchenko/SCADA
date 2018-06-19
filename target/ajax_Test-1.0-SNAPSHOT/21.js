var MONTHS = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
var step = [];
for(var i=0;i<100;i++){
    step[i] = i;
}
var values_to_chart = [];
values_to_chart.push(Number.parseFloat(window.values));


var config = {
    type: 'line',
    data: {
        labels: step,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: window.chartColors.red,
            borderColor: window.chartColors.red,
            data: [values_to_chart],
            fill: false,
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
window.onload = function () {
    var ctx = document.getElementById('myChart').getContext('2d');
    window.myLine = new Chart(ctx,config);
};



