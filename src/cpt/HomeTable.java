package cpt;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.scene.control.Button;


/**
 * @author Noah Lin
 * This is the main class file that launches all of the scenes and controls the menu buttons.
 * This class file should be run in order to use the program. 
 */
public class HomeTable extends Application{
    
    GridPane grid = new GridPane();


 
    /**
     * This method is responsible for handling all buttons and launching all scenes. 
     * It is called when the class file is run. 
     * 
     * 
     * 
     */
    @Override public void start(Stage primaryStage) throws Exception {
    
        //creating scene objects to represent the static methods to draw each type of graph
        Scene tableScene = new Scene(DataTable.makeTable());
        Scene lineChart = new Scene(DataLineChart.makeLineChart());
        Scene barScene = new Scene(BarGraphChart.makeBarChart());

        //object and event handling for the 
        Button btnHomeLineGraph =  DataTable.lineButton;
        Button homeButton = DataLineChart.homeButton;
        Button bargraphButton = DataTable.barButton;
        Button bargrapghButton2 = DataLineChart.barButton;
        Button homeButton2 = BarGraphChart.homeButton;
        Button lineButton2 = BarGraphChart.lineButton;


        //event handling for homepage line graph button
        btnHomeLineGraph.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                
                //sets the primarystage to the line chart scene 
                primaryStage.setScene(lineChart);
                primaryStage.show();
            }
        });


        //event handling for homebutton from the line chart 
        homeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {

                //sets the primarystage to the tablescene
                primaryStage.setScene(tableScene);
                primaryStage.show();
            }
        });

        //event handling for the bargraph button from homescreen 
        bargraphButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                //sets scene to bargraph
                primaryStage.setScene(barScene);
                primaryStage.show();
            }
        });

        //event handling for bargraphbutton from the line chart 
        bargrapghButton2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle (ActionEvent e) {

                //sets scene to bargraph
                primaryStage.setScene(barScene);
                primaryStage.show();
            }
        });

        //event handling for the homebutton from the bargraph
        homeButton2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {

                //sets scene to the datatable
                primaryStage.setScene(tableScene);
                primaryStage.show();
            }
        });

        //event handling for the line graph button from the bar graph 
        lineButton2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle (ActionEvent e) {

                //sets scene to the line chart 
                primaryStage.setScene(lineChart);
                primaryStage.show();
            }
        });


        //sets the scene to display the data table by default when application is run 
        primaryStage.setScene(tableScene);
        primaryStage.setResizable(true);
        primaryStage.show();

        

    }



    
    public static void main(String[] args) {
        launch(args);
    }


    
}
