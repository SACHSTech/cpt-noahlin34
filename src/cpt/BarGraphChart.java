package cpt;

import java.util.Locale.Category;

import javafx.event.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.ToolBar;
import javafx.scene.control.*;

public class BarGraphChart {

    static String[][] arrData = ReadCSV.readCSVFile("/Users/noah/github-classroom/SACHSTech/cpt-noahlin34/src/cpt/data.csv");
    private static NumberAxis yAxis;
    private static CategoryAxis xAxis;
    private static BarChart chart;
    private static GridPane grid;
    public static  Button homeButton = new Button("Home");
    public static  Button lineButton = new Button("Line Chart");
    public static ChoiceBox choiceBox;
    static  XYChart.Series<String, String> australiaSeires = new XYChart.Series<>();
    static   XYChart.Series<String, String> series = new XYChart.Series<>();


    public static Parent makeBarChart() {
        ToolBar toolbar = new ToolBar();
        toolbar.getItems().add(homeButton);
        toolbar.getItems().add(lineButton);
        toolbar.getItems().add(new Button("Bar Graph"));
        GridPane.setConstraints(toolbar, 0, 0);

        choiceBox = new ChoiceBox<>();
        choiceBox.setValue("1956");
        GridPane.setConstraints(choiceBox, 0, 1);

        for(int x = 1956; x <= 2014; x++) {
            choiceBox.getItems().add(x);
        }

 
        grid = new GridPane();

        xAxis = new CategoryAxis();
        xAxis.setLabel("country");
        String prevValue = "";




        yAxis = new NumberAxis(0, 30, 1);
        yAxis.setLabel("Value");


   
            
        choiceBox.setOnAction((event) -> {

           String yearString = choiceBox.getValue().toString();
            populateData(Integer.parseInt(yearString));
            chart.getData().add(series);
            
        });


        
       
        chart = new BarChart<>(xAxis, yAxis);
        chart.setTitle("Coefficient in x year");
        chart.setAnimated(false);

        chart.prefHeightProperty().bind(grid.heightProperty());
        chart.prefWidthProperty().bind(grid.widthProperty());
                
        grid.prefWidthProperty().set(1000);;
        grid.prefHeightProperty().set(800);;
        grid.setConstraints(chart, 0, 2);
        grid.getChildren().addAll(chart, toolbar, choiceBox);
        return grid;
        
    }


    public static void populateData(int year) {
        chart.getData().remove(series);
        series.getData().clear();
        series.setName(Integer.toString(year));

        for(int x = 1; x < arrData.length; x++) {
            if(arrData[x][1].equals(Integer.toString(year)) && arrData[x][0].equals("Australia")) {

                series.getData().add(new XYChart.Data("Australia", Double.parseDouble(arrData[x][2])));
            }
        }
        
        for(int x = 1; x < arrData.length; x++) {
            if(arrData[x][1].equals(Integer.toString(year)) && arrData[x][0].equals("Canada")) {

                series.getData().add(new XYChart.Data("Canada", Double.parseDouble(arrData[x][2])));
                
            }
        }

        for(int x = 1; x < arrData.length; x++) {
            if(arrData[x][1].equals(Integer.toString(year)) && arrData[x][0].equals("Denmark")) {

                series.getData().add(new XYChart.Data("Denmark", Double.parseDouble(arrData[x][2])));
            }
        }

        for(int x = 1; x < arrData.length; x++) {
            if(arrData[x][1].equals(Integer.toString(year)) && arrData[x][0].equals("Finland")) {

                series.getData().add(new XYChart.Data("Finland", Double.parseDouble(arrData[x][2])));
            }
        }
        for(int x = 1; x < arrData.length; x++) {
            if(arrData[x][1].equals(Integer.toString(year)) && arrData[x][0].equals("France")) {

                series.getData().add(new XYChart.Data("France", Double.parseDouble(arrData[x][2])));
            }
        }
        for(int x = 1; x < arrData.length; x++) {
            if(arrData[x][1].equals(Integer.toString(year)) && arrData[x][0].equals("Germany")) {

                series.getData().add(new XYChart.Data("Germany", Double.parseDouble(arrData[x][2])));
            }
        }
        for(int x = 1; x < arrData.length; x++) {
            if(arrData[x][1].equals(Integer.toString(year)) && arrData[x][0].equals("United States")) {

                series.getData().add(new XYChart.Data("United States", Double.parseDouble(arrData[x][2])));
            }
        }
    }

    
}
