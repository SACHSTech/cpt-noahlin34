package cpt;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.*;
import java.util.List;

import javax.sound.sampled.DataLine;
import javax.swing.Action;

import javafx.scene.control.ToolBar;
import javafx.scene.robot.*;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.Group;

import charts.DataRecord;
import charts.MyLineChart;

import java.util.ArrayList;
import cpt.ReadCSV;
import cpt.DataTable;;

public class HomeTable extends Application{
    
    GridPane grid = new GridPane();


 

    @Override public void start(Stage primaryStage) throws Exception {
    
        Scene tableScene = new Scene(DataTable.makeTable());
        Scene lineChart = new Scene(DataLineChart.makeLineChart());
        Scene barScene = new Scene(BarGraphChart.makeBarChart());

        Button myButton =  DataTable.lineButton;

        myButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {

                primaryStage.setScene(lineChart);
                primaryStage.setResizable(true);
            }
        });

        Button homeButton = DataLineChart.homeButton;

        homeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                primaryStage.setScene(tableScene);
                primaryStage.show();
            }
        });

        Button bar

        primaryStage.setScene(tableScene);

        primaryStage.setResizable(true);
        primaryStage.show();

        

    }


    public static void main(String[] args) {
        launch(args);
    }


    
}
