package com.example.thunderstats.service;

import com.example.thunderstats.model.chart.BarData;
import com.example.thunderstats.model.chart.BarDataset;
import com.example.thunderstats.model.stats.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class StatsDataService {



    public BarData convertToChartData(AbstractTwoParamStats abstractTwoParamStats){

        BarData barData = new BarData();
        BarDataset data1 = new BarDataset();
        BarDataset data2 = new BarDataset();

        data1.setLabel("Received");
        data2.setLabel("Sent");
        data1.setBorderWidth(1);
        data2.setBorderWidth(1);
        data1.setBackgroundColor("#FF0000");
        data2.setBackgroundColor("#0000FF");

        if(abstractTwoParamStats instanceof DailyStats){
            barData.setLabels(Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"));
        }
        else if(abstractTwoParamStats instanceof MonthlyStats){
            barData.setLabels(Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));
        }
        else if(abstractTwoParamStats instanceof YearlyStats || abstractTwoParamStats instanceof HourlyStats){
            List<String> labels = new ArrayList<>(abstractTwoParamStats.getStats().keySet());
            Collections.sort(labels);
            barData.setLabels(labels);
        }

        for(String label:barData.getLabels()){
            try {
                data1.add(abstractTwoParamStats.getStats().get(label).get("Received"));
            }
            catch(Exception e){
                data1.add(0);
            }
            try {
                data2.add(abstractTwoParamStats.getStats().get(label).get("Sent"));
            }
            catch (Exception e){
                data2.add(0);
            }
        }

        barData.addDataset(data1);
        barData.addDataset(data2);
        return barData;
    }

    public BarData convertToChartData(AbstractOneParamStats abstractOneParamStats){

        BarData barData = new BarData();
        BarDataset data1 = new BarDataset();

        if(abstractOneParamStats instanceof ReceivedFromStats){
            data1.setLabel("Received from");
            data1.setBackgroundColor("#FF0000");
        }
        else if(abstractOneParamStats instanceof SentToStats){
            data1.setLabel("Sent to");
            data1.setBackgroundColor("#0000FF");
        }

        barData.setLabels(new ArrayList<>(abstractOneParamStats.getTop5().keySet()));
        for(String label: barData.getLabels()){
            try {
                data1.add(abstractOneParamStats.getStats().get(label));
            }
            catch(Exception e){
                data1.add(0);
            }
        }

        data1.setBorderWidth(1);
        barData.addDataset(data1);
        return barData;
    }



}
