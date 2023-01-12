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
import cpt.DataTable;;

public class HomeTable extends Application{
    
    GridPane grid = new GridPane();


   

    public Parent createContent() {

        return grid;
    }  


 

    @Override public void start(Stage primaryStage) throws Exception {

    

        primaryStage.setScene(new Scene(DataTable.makeTable()));

        primaryStage.setResizable(true);
        primaryStage.show();
        


    }


    public static void main(String[] args) {
        launch(args);
    }



    

    
}
