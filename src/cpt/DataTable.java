package cpt;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;


import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;


/**
 * @author Noah Lin
 * This class file contains code to draw the home screen with a table showing all data. 
 * It is final, so it is not overrideable or inheritable 
 */
public final class DataTable {


    
    //static variable declaration, private, dont need to access elsewhere
    private static  String[][] arrData = ReadCSV.readCSVFile("src/cpt/data1.csv");
    private static TableView tableView = new TableView();
    private static GridPane grid = new GridPane();
    private static ChoiceBox<String> choiceBox = new ChoiceBox<>();

    //two public buttons as they need to be accessed from the HomeTable.java file 
    public static  Button lineButton = new Button("Line Chart");
    public static Button barButton = new Button("Bar Graph");

    /**
     * This class contains the code to draw the data table, as well as the above toolbar and dropdown.
     * It is static so it can be called at will from the hometable file without creating a new object
     * @return A gridpane containing all the elements. 
     */
    public static Parent makeTable() {

        //creates a toolbar
        ToolBar toolbar = new ToolBar();

        //adds 3 buttons to the toolbar
        toolbar.getItems().add(new Button("Home"));
        toolbar.getItems().add(lineButton);
        toolbar.getItems().add(barButton);


        //sets toolbar to be in the first row, first column of the gridpane. 
        GridPane.setConstraints(toolbar, 0, 0);

        //tableview is the first column, third row 
        GridPane.setConstraints(tableView, 0, 2);

        //creating choicebox
        choiceBox.getItems().add("All Countries");

        //default value is all countries
        choiceBox.setValue("All Countries");

        //choicepane in first column, second row 
        GridPane.setConstraints(choiceBox, 0, 1);

        //string to keep track of previous country 
        String prevCountry = "";

        /**
         * This for loop iterates through every item in the csv data array.
         * It uses the country string variables to ensure no duplicates.
         * It is a crude linear search algorithm. 
         */
        for(int i = 1; i < arrData.length; i++) {
            
            //keep track of currenet item
            String currentCountry = arrData[i][0];

            //if the country is the same as the last one, step over 
            if(currentCountry.equals(prevCountry)) {
                    continue;
            } else {

                //adds the unique country to the choicebox, update variabl
                choiceBox.getItems().add(currentCountry);
                prevCountry = currentCountry;
            }

        }


        //adding elements to the gridpane. 
        grid.getChildren().addAll(tableView, choiceBox, toolbar);        
        grid.prefWidthProperty().set(1000);;
        grid.prefHeightProperty().set(1000);;

        //event handling for when the choicebox is used
        choiceBox.setOnAction(event -> {
        tableView.getColumns().clear();
        
        //creating data set for the table
        final ObservableList<DataRecord> data = FXCollections.observableArrayList();

        //switch statement for which value is in the choicebox
        switch(choiceBox.getValue()) {

            //all countries selected 
            case "All Countries":
             
                //iterates through every country, adding data for all the countries
                for(int i = 1; i < arrData.length; i++) {

                    //creates instance of datarecord class, passing data as parameters 
                    DataRecord dataRecord = new DataRecord(arrData[i][1], arrData[i][0], arrData[i][2]);
                    data.add(dataRecord);
                }

                //adds data to the table 
                populateTable(data);
                break;

            //australia selected
            case "Australia":
                
                //linear search for australia's data 
                for(int i = 1; i < arrData.length; i++) {
                    if(arrData[i][0].equals("Australia")) {

                        //creates relevant datarecord with the data 
                        DataRecord dataRecord = new DataRecord(arrData[i][1], arrData[1][0], arrData[i][2]);
                        data.add(dataRecord);
                    } else {
                        continue;
                    }
                }

                //adds data 
                populateTable(data);
                break;

            //canada selected
            case "Canada":

                //linear search for elements with canada 
                for(int i = 1; i < arrData.length; i++) {
                    if(arrData[i][0].equals("Canada")) {

                        //creates datarecord with relevant data 
                        DataRecord dataRecord = new DataRecord(arrData[i][1], arrData[i][0], arrData[i][2]);
                        data.add(dataRecord);
                    } else {
                        continue;
                    }
                }

                //adds data 
                populateTable(data);
                break;

            //denmark selected 
            case "Denmark":

                //linear search for elements with denmark 
                for(int i = 1; i < arrData.length; i++) {

                    if(arrData[i][0].equals("Denmark")) {

                        //creates datarecord with relevant data 
                        DataRecord dataRecord = new DataRecord(arrData[i][1], arrData[i][0], arrData[i][2]);
                        data.add(dataRecord);
                    } else {
                        continue;
                    }
                }

                //adds data 
                populateTable(data);
                break;

            //finalnd selected 
            case "Finland":

                //linear search for finland's rows 
                for(int i = 1; i < arrData.length; i++) {
                    if(arrData[i][0].equals("Finland")) {

                        //creates datarecord with relevant data 
                        DataRecord dataRecord = new DataRecord(arrData[i][1], arrData[i][0], arrData[1][2]);
                        data.add(dataRecord);
                    } else {
                        continue;
                    }
                }

                //adds data 
                populateTable(data);
                break;

            //france selected
            case "France":

                //linear search for rows containing france
                for(int i = 1; i < arrData.length; i++) {
                    if(arrData[i][0].equals("France")) {

                        //creates datarecord with relevant data 
                        DataRecord dataRecord = new DataRecord(arrData[i][1], arrData[i][0], arrData[1][2]);
                        data.add(dataRecord);
                    } else {
                        continue;
                    }
                }

                //adds data 
                populateTable(data);
                break;

            //germany selected
            case "Germany":

                //linear search for elements with germany
                for(int i = 1; i < arrData.length; i++) {
                    if(arrData[i][0].equals("Germany")) {

                        //creates datarecord with relevant data 
                        DataRecord dataRecord = new DataRecord(arrData[i][1], arrData[i][0], arrData[1][2]);
                        data.add(dataRecord);
                    } else {
                        continue;
                    }
                }

                //adds data 
                populateTable(data);
                break;

            //united states selected 
            case "United States":

                //linear search for elements with united states
                for(int i = 1; i < arrData.length; i++) {

                    if(arrData[i][0].equals("United States")) {

                        //creates new datarecord with relevant data 
                        DataRecord dataRecord = new DataRecord(arrData[i][1], arrData[i][0], arrData[1][2]);
                        data.add(dataRecord);
                    } else {
                        continue;
                    }
                }

                //adds data
                populateTable(data);
                break;


            }
        });

        //sets the default data to be displayed, all of it 
        final ObservableList<DataRecord> data = FXCollections.observableArrayList();
        
        for(int i = 1; i < arrData.length; i++) {
            DataRecord dataRecord = new DataRecord(arrData[i][1], arrData[i][0], arrData[i][2]);
            data.add(dataRecord);
            }

            populateTable(data);

        return grid;

    }

    /**
     * Method that is called repeatedly in the switch statement to populate the table with relevant data.
     * Nothing is actually returned as it just configures the table 
     *  
     * @param record need to input a datarecord object 
     */
    public static void populateTable(ObservableList<DataRecord> record) {

        //create the country column
        TableColumn columnCountry = new TableColumn();
        columnCountry.setText("Country");

        //setting value factory for the country element of the datarecord 
        columnCountry.setCellValueFactory(new PropertyValueFactory<>("country"));


        //creating the year column 
        TableColumn columnYear = new TableColumn();
        columnYear.setText("Year");

        //setting cell values to the year element of the datarecord 
        columnYear.setCellValueFactory(new PropertyValueFactory<>("year"));

        
        //creating the coefficient column
        TableColumn columnCoefficient = new TableColumn();
        columnCoefficient.setText("Coefficient");

        //setting the cell values to the value element of the datarecord 
        columnCoefficient.setCellValueFactory(new PropertyValueFactory<>("value"));



        //set the items and add call columns 
        tableView.setItems(record);
        tableView.getColumns().addAll(columnCountry, columnYear, columnCoefficient);


        //table view size is bound to the size of the grid 
        tableView.prefHeightProperty().bind(grid.heightProperty());
        tableView.prefWidthProperty().bind(grid.widthProperty());

        
        //column sizes are bound to the size of the tableview, equally distributed 
        columnCountry.prefWidthProperty().bind(tableView.widthProperty().divide(3));
        columnYear.prefWidthProperty().bind(tableView.widthProperty().divide(3));
        columnCoefficient.prefWidthProperty().bind(tableView.widthProperty().divide(3));
        
    }

    
}
