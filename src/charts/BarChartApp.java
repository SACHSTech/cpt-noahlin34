/* ....Show License.... */
package charts;
 
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
 
/**
 * A chart that displays rectangular bars with heights indicating data values
 * for categories. Used for displaying information when at least one axis has
 * discontinuous or discrete data.
 */
public class BarChartApp extends Application {
 
    private BarChart chart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;
 
    String[] temparr;


    public Parent createContent() {
        String[] years = {"2007", "2008", "2009"};
        String delimiter = ",";
      
        List<String[]> records = new ArrayList<>();

        try{
          File file = new File("/Users/noah/github-classroom/SACHSTech/cpt-noahlin34/src/charts/data.csv");
  
          FileReader fileReader = new FileReader(file);
  
          BufferedReader reader = new BufferedReader(fileReader);
  
          String line = "";
  
          while((line = reader.readLine()) != null) {
            temparr = line.split(delimiter);
            records.add(line.split(","));
          }

          
  
        } catch (IOException e) {
          e.printStackTrace();
        }

        String[][] array = new String[records.size()][3];
        records.toArray(array);

        xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(years));
        yAxis = new NumberAxis();
        ObservableList<BarChart.Series> barChartData =
            FXCollections.observableArrayList(
              new BarChart.Series("Australia", FXCollections.observableArrayList(
                new BarChart.Data(years[0],Double.parseDouble(array[1][2])),
                new BarChart.Data(years[1], 1665),
                new BarChart.Data(years[2], 2559))),
              new BarChart.Series("Canada", FXCollections.observableArrayList(
                new BarChart.Data(years[0], Double.parseDouble(array[17][2])),
                new BarChart.Data(years[1], 1927),
                new BarChart.Data(years[2], 2774)))
            );
        chart = new BarChart(xAxis, yAxis, barChartData, 25.0d);
        return chart;
    }
 
    @Override public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }
 
    /**
     * Java main for when running without JavaFX launcher
     */
    public static void main(String[] args) {
        launch(args);
    }


    

    

}