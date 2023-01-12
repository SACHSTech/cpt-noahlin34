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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
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
   final TableView tableView = new TableView();
   GridPane grid = new GridPane();
   ChoiceBox<String> choiceBox = new ChoiceBox<>();


    public Parent createContent() {


        

        GridPane.setConstraints(tableView, 0, 1);


        choiceBox.getItems().add("All Countries");
        choiceBox.setValue("All Countries");



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



        GridPane.setConstraints(choiceBox, 0, 0);



        grid.getChildren().addAll(tableView, choiceBox);        

        grid.prefWidthProperty().set(500);;
        grid.prefHeightProperty().set(500);;

        return grid;

        

    }


    @Override public void start(Stage primaryStage) throws Exception {


         choiceBox.setOnAction(event -> {

            if(choiceBox.getValue().equals("All Countries")) {
                tableView.getColumns().clear();

                final ObservableList<DataRecord> data = FXCollections.observableArrayList();

                for(int i = 1; i < arrData.length; i++) {
                    DataRecord dataRecord = new DataRecord(arrData[i][1], arrData[i][0], arrData[i][2]);
                    data.add(dataRecord);
                }

                populateTable(data);
            }

            if(choiceBox.getValue().equals("Australia")) {
                tableView.getColumns().clear();

                final ObservableList<DataRecord> data = FXCollections.observableArrayList();

                for(int i = 1; i < arrData.length; i++) {
                    if(arrData[i][0].equals("Australia")) {
                        DataRecord dataRecord = new DataRecord(arrData[i][1], arrData[1][0], arrData[i][2]);
                        data.add(dataRecord);
                    } else {
                        continue;
                    }
                }
                populateTable(data);
            }
        });
        
        
    

        primaryStage.setScene(new Scene(createContent()));




        primaryStage.setResizable(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }



    public void populateTable(ObservableList<DataRecord> record) {

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
