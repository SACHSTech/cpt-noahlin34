package cpt;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.*;
import java.util.List;

import charts.DataRecord;

import java.util.ArrayList;
import cpt.ReadCSV;

public class HomeTable extends Application{
    
    
   String[][] arrData = ReadCSV.readCSVFile("/Users/noah/github-classroom/SACHSTech/cpt-noahlin34/src/cpt/data.csv");


    public Parent createContent() {

        final TableView tableView = new TableView<>();

        

        final ObservableList<DataRecord> data = FXCollections.observableArrayList();

        for(int i = 1; i < 470; i++) {
            DataRecord dataRecord = new DataRecord(arrData[i][0], arrData[i][1], arrData[i][2]);
            data.add(dataRecord);
        }


        return tableView;



    }


    @Override public void start(Stage primaryStage) throws e {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
