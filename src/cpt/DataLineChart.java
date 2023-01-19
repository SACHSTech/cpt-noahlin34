package cpt;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.NumberAxis.*;
import javafx.stage.Stage;
import java.util.List;

import javax.swing.Action;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToolBar;

public final class DataLineChart {

    public static  String[][] arrData = ReadCSV.readCSVFile("src/cpt/data1.csv");
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

        HBox HBox = new HBox();
        GridPane.setConstraints(HBox, 0, 1);
        HBox.setSpacing(5);
        
        CheckBox australia = new CheckBox("Australia");
        CheckBox canada = new CheckBox("Canada");
        CheckBox denmark = new CheckBox("Denmark");


        HBox.getChildren().addAll(australia, canada, denmark);

        xAxis = new NumberAxis("Year", 1970, 2016, 1);
        yAxis = new NumberAxis("Gini Coefficient", 20, 40, 1);


        lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setAnimated(false);
        XYChart.Series<Double, Double> australiaSeries = new XYChart.Series<>();
        XYChart.Series<Double, Double> canadaSeries = new XYChart.Series<>();
        XYChart.Series<Double, Double> denmarkSeries = new XYChart.Series<>();

        for(int x = 1; x < arrData.length; x++ ) {
            if(arrData[x][0].equals("Australia")) {

                australiaSeries.getData().add(new XYChart.Data<>(Double.parseDouble(arrData[x][1]), Double.parseDouble(arrData[x][2])));
                australiaSeries.setName(arrData[x][0]);
            } 
         
            if(arrData[x][0].equals("Canada")) {
                canadaSeries.getData().add(new XYChart.Data<>(Double.parseDouble(arrData[x][1]), Double.parseDouble(arrData[x][2])));
                canadaSeries.setName("Canada");
            }

            if(arrData[x][0].equals("Denmark")) {
                denmarkSeries.getData().add(new XYChart.Data<>(Double.parseDouble(arrData[x][1]), Double.parseDouble(arrData[x][2])));
                denmarkSeries.setName("Denmark");
            }
                
        }

        

        australia.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                if(australia.isSelected()) {
                    lineChart.getData().add(australiaSeries);
                } else {
                    lineChart.getData().remove(australiaSeries);
                }
            }
        });

        canada.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                if(canada.isSelected()) {
                    lineChart.getData().add(canadaSeries);
                } else {
                    lineChart.getData().remove(canadaSeries);
                }
            }
        });


        denmark.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(denmark.isSelected()) {
                    lineChart.getData().add(denmarkSeries);

                } else {
                    lineChart.getData().remove(denmarkSeries);
                }
            }
        });



        grid.prefWidthProperty().set(1000);;
        grid.prefHeightProperty().set(1000);;
      
        lineChart.prefHeightProperty().bind(grid.heightProperty());
        lineChart.prefWidthProperty().bind(grid.widthProperty());

        GridPane.setConstraints(lineChart, 0, 2);

        grid.getChildren().addAll(toolbar, lineChart, HBox);

        return grid;
    }
    


    
}
