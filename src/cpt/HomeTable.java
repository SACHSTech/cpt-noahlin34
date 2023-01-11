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
import java.util.ArrayList;
import cpt.ReadCSV;

public class HomeTable extends Application{
    
    
   String[][] arrData = ReadCSV.readCSVFile("/Users/noah/github-classroom/SACHSTech/cpt-noahlin34/src/cpt/data.csv");


    public Parent createContent() {

        final TableView tableView = new TableView<>();

        return tableView;



    }


    @Override public void start(Stage primaryStage) throws e {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

}
