package cpt;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.GridPane;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;
import java.util.List;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

public final class DataLineChart {

    public static  String[][] arrData = ReadCSV.readCSVFile("/Users/noah/github-classroom/SACHSTech/cpt-noahlin34/src/cpt/data.csv");
    public static LineChart lineChart;
    public static NumberAxis xAxis;
    public static NumberAxis yAxis;
    public static GridPane grid = new GridPane();
    public static  Button homeButton = new Button("Home");

    public static Parent makeLineChart() {

        ToolBar toolbar = new ToolBar();
        toolbar.getItems().add(homeButton);
        toolbar.getItems().add(new Button("Line Chart"));
        toolbar.getItems().add(new Button("Bar Graph"));
        GridPane.setConstraints(toolbar, 0, 0);




        xAxis = new NumberAxis("Year", 1980, 2020, 1);
        yAxis = new NumberAxis("Gini Coefficient", 20, 40, 1);

        lineChart = new LineChart<>(xAxis, yAxis);
        String prevCountry = "Australia";
        XYChart.Series<Double, Double> series = new XYChart.Series<>();

        for(int x = 1; x < arrData.length; x++ ) {
            String currentCountry = arrData[x][0];
            if(currentCountry.equals(prevCountry)) {
                series.getData().add(new XYChart.Data<>(Double.parseDouble(arrData[x][1]), Double.parseDouble(arrData[x][2])));
                series.setName("AUSTRALIA");
                lineChart.getData().add(series);

                } else {

            }

            
        }

        GridPane.setConstraints(lineChart, 0, 1);

        grid.getChildren().addAll(toolbar, lineChart);

        return grid;
    }
    


    
}
