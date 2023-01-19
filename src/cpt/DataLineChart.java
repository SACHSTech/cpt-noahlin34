package cpt;

import javafx.application.Application;
import javafx.beans.property.Property;
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
        CheckBox finland = new CheckBox("Finland");
        CheckBox france = new CheckBox("France");
        CheckBox germany = new CheckBox("Germany");
        CheckBox unitedstates = new CheckBox("United States");


        HBox.getChildren().addAll(australia, canada, denmark, finland, france, germany, unitedstates);

        xAxis = new NumberAxis("Year", 1950, 2016, 1);
        yAxis = new NumberAxis("Gini Coefficient", 20, 40, 1);


        lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setAnimated(false);
        XYChart.Series<Double, Double> australiaSeries = new XYChart.Series<>();
        XYChart.Series<Double, Double> canadaSeries = new XYChart.Series<>();
        XYChart.Series<Double, Double> denmarkSeries = new XYChart.Series<>();
        XYChart.Series<Double, Double> finlandSeries = new XYChart.Series<>();
        XYChart.Series<Double, Double> franceSeries = new XYChart.Series<>();
        XYChart.Series<Double, Double> germanySeries = new XYChart.Series<>();
        XYChart.Series<Double, Double> unitedstatesSeries = new XYChart.Series<>();


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

            if(arrData[x][0].equals("Finland")) {
                finlandSeries.getData().add(new XYChart.Data<>(Double.parseDouble(arrData[x][1]), Double.parseDouble(arrData[x][2])));
                finlandSeries.setName("Finland");
            }
                
            if(arrData[x][0].equals("France")) {
                franceSeries.getData().add(new XYChart.Data<>(Double.parseDouble(arrData[x][1]), Double.parseDouble(arrData[x][2])));
                franceSeries.setName("France");
            }

            if(arrData[x][0].equals("Germany")) {
                germanySeries.getData().add(new XYChart.Data<>(Double.parseDouble(arrData[x][1]), Double.parseDouble(arrData[x][2])));
                germanySeries.setName("Germany");
            }

            if(arrData[x][0].equals("United States")) {
                unitedstatesSeries.getData().add(new XYChart.Data<>(Double.parseDouble(arrData[x][1]), Double.parseDouble(arrData[x][2])));
                unitedstatesSeries.setName("United States");
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

        finland.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(finland.isSelected()) {
                    lineChart.getData().add(finlandSeries);

                } else {
                    lineChart.getData().remove(finlandSeries);
                }
            }
        });

        france.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(france.isSelected()) {
                    lineChart.getData().add(franceSeries);

                } else {
                    lineChart.getData().remove(franceSeries);
                }
            }
        });

        germany.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(germany.isSelected()) {
                    lineChart.getData().add(germanySeries);

                } else {
                    lineChart.getData().remove(germanySeries);
                }
            }
        });

        unitedstates.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(unitedstates.isSelected()) {
                    lineChart.getData().add(unitedstatesSeries);

                } else {
                    lineChart.getData().remove(unitedstatesSeries);
                }
            }
        });



        grid.prefWidthProperty().set(1000);;
        grid.prefHeightProperty().set(800);;
      
       

        lineChart.prefHeightProperty().bind(grid.heightProperty());
        lineChart.prefWidthProperty().bind(grid.widthProperty());

        GridPane.setConstraints(lineChart, 0, 2);

        grid.getChildren().addAll(toolbar, lineChart, HBox);

        return grid;
    }
    


    
}
