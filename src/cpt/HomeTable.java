package cpt;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
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

        GridPane grid = new GridPane();
        

        


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

        GridPane.setConstraints(tableView, 0, 1);


        ChoiceBox choiceBox = new ChoiceBox();


        String prevCountry = "";
        for(int i = 0; i < arrData.length; i++) {
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


        return grid;

        

        

    }


    @Override public void start(Stage primaryStage) throws Exception {





        primaryStage.setScene(new Scene(createContent()));
        primaryStage.setResizable(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
