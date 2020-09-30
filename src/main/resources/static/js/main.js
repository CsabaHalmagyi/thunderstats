
function displayMessage(message, type){
    var msgDiv = jQuery('<div class="alert alert-'+type+' fading-alert">'+message+'</div>');
    jQuery("#messagesDiv").empty().append(msgDiv);
    msgDiv.delay(2000).slideUp(200, function() {
        $(this).alert('close');
    });
}

function initStats(){
    var mailDir = jQuery("#pwd").val();
    var senderEmail = jQuery("#email").val();
    $.ajax({
        type: 'POST', //post method
        url: '/init?dir='+encodeURIComponent(mailDir)+'&email='+encodeURIComponent(senderEmail), //ajaxformexample url
        dataType: "json",
        success: function (result)
        {

            if(result == "0") {
                displayMessage("There are "+result+" .eml files in given directory. Please check directory path", "danger");
            }
            else{
                getDailyStatsData();
                getMonthlyStatsData();
                getYearlyStatsData();
                getHourlyStatsData();
                getSentToStatsData();
                getReceivedFromStatsData();
                getDaysMostReceivedStatsData();
                getDaysMostSentStatsData();
                displayMessage("Found "+result+" email(s) in given directory. Creating charts.", "success");
            }

        },
        error: function (){
            displayMessage("Error when reading emails from given directory.", "danger");
        }
    });
}


function getDailyStatsData(){
    $.ajax({
        type: 'POST', //post method
        url: '/dailystats', //ajaxformexample url
        dataType: "json",
        success: function (result)
        {

            var dailyChart = new Chart( document.getElementById('dailyStats').getContext('2d'), {
                type: "bar",
                data: {},
                options: {
                    title: {
                        display: true,
                        text: 'Emails by day'
                    }}
            });
            dailyChart.data = result;
            dailyChart.update();
        }
    });
}


function getMonthlyStatsData(){
    $.ajax({
        type: 'POST', //post method
        url: '/monthlystats', //ajaxformexample url
        dataType: "json",
        success: function (result)
        {

            var monthlyChart = new Chart( document.getElementById('monthlyStats').getContext('2d'), {
                type: "bar",
                data: {},
                options: {
                    title: {
                        display: true,
                        text: 'Emails by month'
                    }}
            });
            monthlyChart.data = result;
            monthlyChart.update();
        }
    });
}


function getYearlyStatsData(){
    $.ajax({
        type: 'POST', //post method
        url: '/yearlystats', //ajaxformexample url
        dataType: "json",
        success: function (result)
        {

            var yearlyChart = new Chart( document.getElementById('yearlyStats').getContext('2d'), {
                type: "bar",
                data: {},
                options: {
                    title: {
                        display: true,
                        text: 'Emails by year'
                    }}
            });
            yearlyChart.data = result;
            yearlyChart.update();
        }
    });
}

function getHourlyStatsData(){
    $.ajax({
        type: 'POST', //post method
        url: '/hourlystats', //ajaxformexample url
        dataType: "json",
        success: function (result)
        {

            var hourlyChart = new Chart( document.getElementById('hourlyStats').getContext('2d'), {
                type: "bar",
                data: {},
                options: {
                    title: {
                        display: true,
                        text: 'Emails by hour'
                    }}
            });
            hourlyChart.data = result;
            hourlyChart.update();
        }
    });
}

function getSentToStatsData(){
    $.ajax({
        type: 'POST', //post method
        url: '/senttostats', //ajaxformexample url
        dataType: "json",
        success: function (result)
        {

            var sentToChart = new Chart( document.getElementById('sentToStats').getContext('2d'), {
                type: "bar",
                data: {},
                options: {
                    title: {
                        display: true,
                        text: 'Top 5 addressee'
                    }}
            });
            sentToChart.data = result;
            sentToChart.update();
        }
    });
}

function getReceivedFromStatsData(){
    $.ajax({
        type: 'POST', //post method
        url: '/receivedfromstats', //ajaxformexample url
        dataType: "json",
        success: function (result)
        {

            var receivedFromChart = new Chart( document.getElementById('receivedFromStats').getContext('2d'), {
                type: "bar",
                data: {},
                options: {
                    title: {
                        display: true,
                        text: 'Top 5 sender'
                    }}
            });
            receivedFromChart.data = result;
            receivedFromChart.update();
        }
    });
}

function getDaysMostReceivedStatsData(){
    $.ajax({
        type: 'POST', //post method
        url: '/daysmostreceivedstats', //ajaxformexample url
        dataType: "json",
        success: function (result)
        {

            var daysMostReceivedChart = new Chart( document.getElementById('daysMostReceivedStats').getContext('2d'), {
                type: "bar",
                data: {},
                options: {
                    title: {
                        display: true,
                        text: 'Top 5 busiest days'
                    }}
            });
            daysMostReceivedChart.data = result;
            daysMostReceivedChart.update();
        }
    });
}

function getDaysMostSentStatsData(){
    $.ajax({
        type: 'POST', //post method
        url: '/daysmostsentstats', //ajaxformexample url
        dataType: "json",
        success: function (result)
        {

            var daysMostSentChart = new Chart( document.getElementById('daysMostSentStats').getContext('2d'), {
                type: "bar",
                data: {},
                options: {
                    title: {
                        display: true,
                        text: 'Top 5 busiest days'
                    }}
            });
            daysMostSentChart.data = result;
            daysMostSentChart.update();
        }
    });
}