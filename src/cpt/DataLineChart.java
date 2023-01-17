package cpt;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;
import java.util.List;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;


public final class DataLineChart {

    public static  String[][] arrData = ReadCSV.readCSVFile("/Users/noah/github-classroom/SACHSTech/cpt-noahlin34/src/cpt/data.csv");
    public static LineChart lineChart;
    public static NumberAxis xAxis;
    public static NumberAxis yAxis;

    public static Parent makeLineChart() {

        xAxis = new NumberAxis("Year", 1980, 2020, 1);
        yAxis = new NumberAxis("Gini Coefficient", 20, 40, 1);

        lineChart = new LineChart<>(xAxis, yAxis);
        String prevCountry = "Australia";
        for(int x = 1; x < arrData.length; x++ ) {
            String currentCountry = arrData[x][0];
            XYChart.Series<Double, Double> series = new XYChart.Series<>();
            if(currentCountry.equals(prevCountry)) {
                series.getData().add(new XYChart.Data<>(Double.parseDouble(arrData[x][1]), Double.parseDouble(arrData[x][2])));
                series.setName("AUSTRALIA");
                } else {
                break;
            }
            
           lineChart.getData().add(series);
        }


        return lineChart;
    }
    


    
}
