package cpt;

import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ToolBar;
import javafx.scene.control.*;


/**
 * @author Noah Lin
 * This class handles the bar graph generation 
 */
public class BarGraphChart {

    //private variable declaration, only used in this class
    private static String[][] arrData = ReadCSV.readCSVFile("src/cpt/data1.csv");
    private static NumberAxis yAxis;
    private static CategoryAxis xAxis;
    private static BarChart chart;
    private static GridPane grid;
    private static ChoiceBox choiceBox;

    //public button declaration
    public static  Button homeButton = new Button("Home");
    public static  Button lineButton = new Button("Line Chart");

    
    static  XYChart.Series<String, String> australiaSeires = new XYChart.Series<>();
    static   XYChart.Series<String, String> series = new XYChart.Series<>();


    /**
     * Parent method that creates the barchart. 
     * 
     * @return Gridpalne containing all elements 
     */
    public static Parent makeBarChart() {

        //top toolbar to contain navigation buttons 
        ToolBar toolbar = new ToolBar();
        toolbar.getItems().add(homeButton);
        toolbar.getItems().add(lineButton);
        toolbar.getItems().add(new Button("Bar Graph"));
        GridPane.setConstraints(toolbar, 0, 0);

        //choicebox to select year, default value is 1956 
        choiceBox = new ChoiceBox<>();
        GridPane.setConstraints(choiceBox, 0, 1);


        //adds every year between 1965 and 2014 to represent the entire data set 
        for(int x = 1956; x <= 2014; x++) {
            choiceBox.getItems().add(x);
        }

 
        grid = new GridPane();

        //creates x axis as category axis 
        xAxis = new CategoryAxis();
        xAxis.setLabel("country");

        //creates y axis as a number axis, upperbound is 40 
        yAxis = new NumberAxis(0, 40, 1);
        yAxis.setLabel("Value");


   
        //event handling for choicebox  
        choiceBox.setOnAction((event) -> {

            //gets the value of the choicebox 
            String yearString = choiceBox.getValue().toString();

            //populates the graph with the data from the slelected year 
            populateData(Integer.parseInt(yearString));
            chart.getData().add(series);

            //dynamically sets the title 
            chart.setTitle("Gini Coefficient by Country in " + Integer.parseInt(yearString));
            
        });


        
       //declaring barchart 
        chart = new BarChart<>(xAxis, yAxis);
        chart.setTitle("Gini Coefficient by Country in ");
        chart.setAnimated(false);

        //binds chart height to the gridpane 
        chart.prefHeightProperty().bind(grid.heightProperty());
        chart.prefWidthProperty().bind(grid.widthProperty());
                
        //default gridpane size 
        grid.prefWidthProperty().set(1000);;
        grid.prefHeightProperty().set(800);;
        grid.setConstraints(chart, 0, 2);
        grid.getChildren().addAll(chart, toolbar, choiceBox);
        return grid;
        
    }


    /**
     * This method doesn't return anything, but populates the bar graph with each country's data in the given year 
     * @param year year to retrieve and set data for 
     */
    public static void populateData(int year) {

        //clears the chart first 
        chart.getData().remove(series);
        series.getData().clear();
        
        //sets the series name 
        series.setName(Integer.toString(year));

        //Crude linear search algorithm to grab data from each country for the given year, and add it to the series  
        for(int x = 1; x < arrData.length; x++) {
            if(arrData[x][1].equals(Integer.toString(year)) && arrData[x][0].equals("Australia")) {
                series.getData().add(new XYChart.Data("Australia", Double.parseDouble(arrData[x][2])));
            }

            if(arrData[x][1].equals(Integer.toString(year)) && arrData[x][0].equals("Canada")) {

                series.getData().add(new XYChart.Data("Canada", Double.parseDouble(arrData[x][2])));
                
            }

            if(arrData[x][1].equals(Integer.toString(year)) && arrData[x][0].equals("Denmark")) {

                series.getData().add(new XYChart.Data("Denmark", Double.parseDouble(arrData[x][2])));
            }

            if(arrData[x][1].equals(Integer.toString(year)) && arrData[x][0].equals("Finland")) {

                series.getData().add(new XYChart.Data("Finland", Double.parseDouble(arrData[x][2])));
            }

            if(arrData[x][1].equals(Integer.toString(year)) && arrData[x][0].equals("France")) {

                series.getData().add(new XYChart.Data("France", Double.parseDouble(arrData[x][2])));
            }

            if(arrData[x][1].equals(Integer.toString(year)) && arrData[x][0].equals("Germany")) {

                series.getData().add(new XYChart.Data("Germany", Double.parseDouble(arrData[x][2])));
            }

            if(arrData[x][1].equals(Integer.toString(year)) && arrData[x][0].equals("United States")) {

                series.getData().add(new XYChart.Data("United States", Double.parseDouble(arrData[x][2])));
            }
        }

       
    }

    
}
