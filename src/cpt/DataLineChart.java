package cpt;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.scene.chart.NumberAxis;


import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToolBar;


/**
 * @author Noah Lin
 * This class handles generating the line chart 
 * Final, is not inheritable or overrideable 
 */
public final class DataLineChart {

    //declaring private variables that don't need to be accessed outside the class 
    private static  String[][] arrData = ReadCSV.readCSVFile("src/cpt/data1.csv");
    private static LineChart lineChart;
    private static NumberAxis xAxis;
    private static NumberAxis yAxis;
    private static GridPane grid = new GridPane();

    //public buttons that need to be accessed elsewhere
    public static  Button homeButton = new Button("Home");
    public static Button barButton = new Button("Bar Graph ");

    /**
     * This method returns the object containing the line chart, toolbar, and selection boxes.
     * It is static so it can be called without creating a datalinechart object
     * @return returns a gridpane containing all elements.
     */
    public static Parent makeLineChart() {
        


        //create toolbar containing buttons 
        ToolBar toolbar = new ToolBar();
        toolbar.getItems().add(homeButton);
        toolbar.getItems().add(new Button("Line Chart"));
        toolbar.getItems().add(barButton);
        GridPane.setConstraints(toolbar, 0, 0);

        
        //creates the hbox that will hold the checkboxes 
        HBox HBox = new HBox();
        GridPane.setConstraints(HBox, 0, 1);
        HBox.setSpacing(5);
        
        //checkbox for all countries 
        CheckBox australia = new CheckBox("Australia");
        CheckBox canada = new CheckBox("Canada");
        CheckBox denmark = new CheckBox("Denmark");
        CheckBox finland = new CheckBox("Finland");
        CheckBox france = new CheckBox("France");
        CheckBox germany = new CheckBox("Germany");
        CheckBox unitedstates = new CheckBox("United States");

        //add the checkboxes to the hbox 
        HBox.getChildren().addAll(australia, canada, denmark, finland, france, germany, unitedstates);

        //creating x and y axis, both numberaxies
        xAxis = new NumberAxis("Year", 1950, 2016, 1);
        yAxis = new NumberAxis("Gini Coefficient", 20, 40, 1);

        //creating the linechart, settings the axies 
        lineChart = new LineChart<>(xAxis, yAxis);

        //disabling animation, because it would crash the program 
        lineChart.setAnimated(false);

        //creating one series for each country's data 
        XYChart.Series<Double, Double> australiaSeries = new XYChart.Series<>();
        XYChart.Series<Double, Double> canadaSeries = new XYChart.Series<>();
        XYChart.Series<Double, Double> denmarkSeries = new XYChart.Series<>();
        XYChart.Series<Double, Double> finlandSeries = new XYChart.Series<>();
        XYChart.Series<Double, Double> franceSeries = new XYChart.Series<>();
        XYChart.Series<Double, Double> germanySeries = new XYChart.Series<>();
        XYChart.Series<Double, Double> unitedstatesSeries = new XYChart.Series<>();

        /**
         * This massive for loop is a very big linear search algorithm.
         * It searches the array for each country's data, and adds it to the relevant series. 
         * 
         */
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

        
        //event handling for australia checkbox 
        australia.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {

                if(australia.isSelected()) {

                    //displays the australia series if checked 
                    lineChart.getData().add(australiaSeries);
                } else {

                    //hides it when unchecked 
                    lineChart.getData().remove(australiaSeries);
                }
            }
        });

        //event handling for canadacheckbox
        canada.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                if(canada.isSelected()) {

                    //displays canada series when checked 
                    lineChart.getData().add(canadaSeries);
                } else {

                    //hides it otherwise 
                    lineChart.getData().remove(canadaSeries);
                }
            }
        });


        //event handling for denmark checkbox
        denmark.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(denmark.isSelected()) {

                    //displays denmark when checked 
                    lineChart.getData().add(denmarkSeries);

                } else {

                    //hides it otherwise 
                    lineChart.getData().remove(denmarkSeries);
                }
            }
        });

        //event handling for finland checkbox 
        finland.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(finland.isSelected()) {

                    //displays the finland series when checked
                    lineChart.getData().add(finlandSeries);

                } else {

                    //hides it otherwise 
                    lineChart.getData().remove(finlandSeries);
                }
            }
        });


        //event handling for france checkbox
        france.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(france.isSelected()) {
                    
                    //displays france series when checked 
                    lineChart.getData().add(franceSeries);

                } else {

                    //hides it otherwise 
                    lineChart.getData().remove(franceSeries);
                }
            }
        });

        //event handling for germany checkbox 
        germany.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(germany.isSelected()) {

                    //displays germany series when checked 
                    lineChart.getData().add(germanySeries);

                } else {

                    //hides it otherwise 
                    lineChart.getData().remove(germanySeries);
                }
            }
        });


        //united states checkbox event handling 
        unitedstates.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(unitedstates.isSelected()) {

                    //displays data series when checked 
                    lineChart.getData().add(unitedstatesSeries);

                } else {

                    //hides it otherwise 
                    lineChart.getData().remove(unitedstatesSeries);
                }
            }
        });


        //set default size for the grid 
        grid.prefWidthProperty().set(1000);;
        grid.prefHeightProperty().set(800);;
      
       
        //binds linechart size to the size of the grid 
        lineChart.prefHeightProperty().bind(grid.heightProperty());
        lineChart.prefWidthProperty().bind(grid.widthProperty());
        lineChart.setTitle("Gini Coefficient by Country 1950-2016");


        GridPane.setConstraints(lineChart, 0, 2);


        //adds all elements to the gridpane 
        grid.getChildren().addAll(toolbar, lineChart, HBox);

        return grid;
    }
    


    
}
