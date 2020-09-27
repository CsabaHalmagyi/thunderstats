package com.example.thunderstats.model.chart;

import java.util.ArrayList;
import java.util.List;

public class BarDataset {

    private String label;
    private List<Integer> data;
    private int borderWidth;
    private String backgroundColor;

    public BarDataset() {
        data = new ArrayList<>();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void add(int i){
        data.add(i);
    }
}
