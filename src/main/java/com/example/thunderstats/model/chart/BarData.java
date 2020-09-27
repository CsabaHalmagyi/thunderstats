package com.example.thunderstats.model.chart;

import java.util.ArrayList;
import java.util.List;

public class BarData {

    private List<String> labels;
    private List<BarDataset> datasets;

    public BarData() {
        labels = new ArrayList<>();
        datasets = new ArrayList<>();
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<BarDataset> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<BarDataset> datasets) {
        this.datasets = datasets;
    }

    public void addDataset(BarDataset dataset){
        datasets.add(dataset);
    }
}
