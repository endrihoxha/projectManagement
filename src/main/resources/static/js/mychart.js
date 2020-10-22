//here we decode the variable chartData that cames from the JS , returns a String, and parse the String to JSON
var chartDataStr= decodeHtml(chartData);
var chartJsonArray = JSON.parse(chartDataStr);

var arrayLength = chartJsonArray.length;

var numericData = [];
var labelData = [];

for(var i=0; i<arrayLength ; i++){
	numericData[i]=chartJsonArray[i].value;
	labelData[i]=chartJsonArray[i].label;
}

// For a pie chart
 new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3e95cd","#8e5ea2","#3cba9f"],
            data: numericData
        }]
    },

    // Configuration options go here
    options: {
    	title: {
    		display: true,
    		text: 'Project Status'
    	}
    }
});
 
 
// function to decode crypted info
 function decodeHtml(html){
	 var txt = document.createElement("textarea");
	 txt.innerHTML=html;
	 return txt.value;
 }