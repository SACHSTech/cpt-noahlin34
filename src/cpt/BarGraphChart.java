package cpt;

import java.util.Locale.Category;

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

    public static Parent makeBarChart() {
        ToolBar toolbar = new ToolBar();
        toolbar.getItems().add(homeButton);
        toolbar.getItems().add(lineButton);
        toolbar.getItems().add(new Button("Bar Graph"));
        GridPane.setConstraints(toolbar, 0, 0);


 ;
        grid = new GridPane();

        xAxis = new CategoryAxis();
        xAxis.setLabel("country");
        String prevValue = "";




        yAxis = new NumberAxis(0, 30, 1);
        yAxis.setLabel("Value");


        XYChart.Series<String, String> series1 = new XYChart.Series<>();
            
        
            
        
        series1.setName("Canada");
        series1.getData().add(new XYChart.Data("Canada", 14));
       
        chart = new BarChart<>(xAxis, yAxis);
        chart.setTitle("Coefficient in x year");

        chart.getData().add(series1);

        grid.setConstraints(chart, 0, 1);
        grid.getChildren().addAll(chart, toolbar);
        return grid;
        
    }

    
}
