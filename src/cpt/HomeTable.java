package cpt;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.*;
import java.util.List;
import javafx.scene.control.ChoiceBox;
import javafx.scene.Group;

import charts.DataRecord;

import java.util.ArrayList;
import cpt.ReadCSV;

public class HomeTable extends Application{
    
    
   String[][] arrData = ReadCSV.readCSVFile("/Users/noah/github-classroom/SACHSTech/cpt-noahlin34/src/cpt/data.csv");


    public Parent createContent() {


        

        final ObservableList<DataRecord> data = FXCollections.observableArrayList();

        for(int i = 1; i < 470; i++) {
            DataRecord dataRecord = new DataRecord(arrData[i][0], arrData[i][1], arrData[i][2]);
            data.add(dataRecord);
        }


        TableColumn columnCountry = new TableColumn();
        columnCountry.setText("Country");
        columnCountry.setCellValueFactory(new PropertyValueFactory<>("country"));

        TableColumn columnYear = new TableColumn();
        columnYear.setText("Year");
        columnYear.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn columnCoefficient = new TableColumn();
        columnCoefficient.setText("Coefficient");
        columnCoefficient.setCellValueFactory(new PropertyValueFactory<>("value"));



        final TableView tableView = new TableView();

        tableView.setItems(data);
        tableView.getColumns().addAll(columnCountry, columnYear, columnCoefficient);



        


        Group group = new Group();
        group.getChildren().add(tableView);
        


        return group;

        

        

    }


    @Override public void start(Stage primaryStage) throws Exception {





        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
