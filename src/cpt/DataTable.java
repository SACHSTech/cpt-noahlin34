package cpt;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
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
import javafx.scene.control.ToolBar;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.Group;

import charts.DataRecord;

import java.util.ArrayList;
import cpt.ReadCSV;

public final class DataTable {
  static  String[][] arrData = ReadCSV.readCSVFile("/Users/noah/github-classroom/SACHSTech/cpt-noahlin34/src/cpt/data.csv");
    static TableView tableView = new TableView();
   static GridPane grid = new GridPane();
    static ChoiceBox<String> choiceBox = new ChoiceBox<>();

public static Parent makeTable() {
    
    ToolBar toolbar = new ToolBar();
        toolbar.getItems().add(new Button("Home"));
        toolbar.getItems().add(new Button("Line Chart"));
        toolbar.getItems().add(new Button("Bar Graph"));

        GridPane.setConstraints(toolbar, 0, 0);

        GridPane.setConstraints(tableView, 0, 2);


        choiceBox.getItems().add("All Countries");
        choiceBox.setValue("All Countries");
        GridPane.setConstraints(choiceBox, 0, 1);



        String prevCountry = "";
        for(int i = 1; i < arrData.length; i++) {
            String currentCountry = arrData[i][0];

            if(currentCountry.equals(prevCountry)) {
                continue;
            } else {
                choiceBox.getItems().add(currentCountry);
                prevCountry = currentCountry;
            }

        }







        grid.getChildren().addAll(tableView, choiceBox, toolbar);        

        grid.prefWidthProperty().set(500);;
        grid.prefHeightProperty().set(500);;


        choiceBox.setOnAction(event -> {
        tableView.getColumns().clear();
           
        final ObservableList<DataRecord> data = FXCollections.observableArrayList();

            switch(choiceBox.getValue()) {

                case "All Countries":
             
                for(int i = 1; i < arrData.length; i++) {
                    DataRecord dataRecord = new DataRecord(arrData[i][1], arrData[i][0], arrData[i][2]);
                    data.add(dataRecord);
                    }

                    populateTable(data);
                    break;

                case "Australia":
                

                for(int i = 1; i < arrData.length; i++) {
                    if(arrData[i][0].equals("Australia")) {
                        DataRecord dataRecord = new DataRecord(arrData[i][1], arrData[1][0], arrData[i][2]);
                        data.add(dataRecord);
                    } else {
                        continue;
                    }
                }
                populateTable(data);
                break;

                case "Canada":

                for(int i = 1; i < arrData.length; i++) {
                    if(arrData[i][0].equals("Canada")) {
                        DataRecord dataRecord = new DataRecord(arrData[i][1], arrData[i][0], arrData[i][2]);
                        data.add(dataRecord);
                    } else {
                        continue;
                    }
                }
                populateTable(data);
                break;

                case "Denmark":
                for(int i = 1; i < arrData.length; i++) {
                    if(arrData[i][0].equals("Denmark")) {
                        DataRecord dataRecord = new DataRecord(arrData[i][1], arrData[i][0], arrData[i][2]);
                        data.add(dataRecord);
                    } else {
                        continue;
                    }
                }
                populateTable(data);
                break;




            }
        });
        final ObservableList<DataRecord> data = FXCollections.observableArrayList();

        for(int i = 1; i < arrData.length; i++) {
            DataRecord dataRecord = new DataRecord(arrData[i][1], arrData[i][0], arrData[i][2]);
            data.add(dataRecord);
            }

            populateTable(data);

        return grid;

    }
    public static void populateTable(ObservableList<DataRecord> record) {

        TableColumn columnCountry = new TableColumn();
        columnCountry.setText("Country");
        columnCountry.setCellValueFactory(new PropertyValueFactory<>("country"));

        TableColumn columnYear = new TableColumn();
        columnYear.setText("Year");
        columnYear.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn columnCoefficient = new TableColumn();
        columnCoefficient.setText("Coefficient");
        columnCoefficient.setCellValueFactory(new PropertyValueFactory<>("value"));




        tableView.setItems(record);
        tableView.getColumns().addAll(columnCountry, columnYear, columnCoefficient);

        tableView.prefHeightProperty().bind(grid.heightProperty());
        tableView.prefWidthProperty().bind(grid.widthProperty());

        columnCountry.prefWidthProperty().bind(tableView.widthProperty().divide(3));
        columnYear.prefWidthProperty().bind(tableView.widthProperty().divide(3));
        columnCoefficient.prefWidthProperty().bind(tableView.widthProperty().divide(3));
        
    }

    
}
