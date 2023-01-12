/*
 * Copyright (c) 2008, 2016, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle Corporation nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package charts;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;
import java.util.List;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;


/**
 * A chart in which lines connect a series of data points. Useful for viewing
 * data trends over time.
 *
 * @sampleName Line Chart
 * @preview preview.png
 * @docUrl https://docs.oracle.com/javafx/2/charts/jfxpub-charts.htm Using JavaFX Charts Tutorial
 * @playground chart.data
 * @playground - (name="xAxis")
 * @playground xAxis.autoRanging
 * @playground xAxis.forceZeroInRange
 * @playground xAxis.lowerBound (min=-10,max=10,step=0.2)
 * @playground xAxis.upperBound (max=10,step=0.2)
 * @playground xAxis.tickUnit (max=3,step=0.2)
 * @playground xAxis.minorTickCount (max=16)
 * @playground xAxis.minorTickLength (max=15)
 * @playground xAxis.minorTickVisible
 * @playground xAxis.animated
 * @playground xAxis.label
 * @playground xAxis.side
 * @playground xAxis.tickLabelFill
 * @playground xAxis.tickLabelGap
 * @playground xAxis.tickLabelRotation (min=-180,max=180,step=1)
 * @playground xAxis.tickLabelsVisible
 * @playground xAxis.tickLength
 * @playground xAxis.tickMarkVisible
 * @playground - (name="yAxis")
 * @playground yAxis.autoRanging
 * @playground yAxis.forceZeroInRange
 * @playground yAxis.lowerBound (min=-5,max=5,step=0.2)
 * @playground yAxis.upperBound (max=10,step=0.2)
 * @playground yAxis.tickUnit (max=3,step=0.2)
 * @playground yAxis.minorTickCount (max=16)
 * @playground yAxis.minorTickLength (max=15)
 * @playground yAxis.minorTickVisible
 * @playground yAxis.animated
 * @playground yAxis.label
 * @playground yAxis.side
 * @playground yAxis.tickLabelFill
 * @playground yAxis.tickLabelGap
 * @playground yAxis.tickLabelRotation (min=-180,max=180,step=1)
 * @playground yAxis.tickLabelsVisible
 * @playground yAxis.tickLength
 * @playground yAxis.tickMarkVisible
 * @playground - (name="chart")
 * @playground chart.horizontalGridLinesVisible
 * @playground chart.horizontalZeroLineVisible
 * @playground chart.verticalGridLinesVisible
 * @playground chart.verticalZeroLineVisible
 * @playground chart.animated
 * @playground chart.legendSide
 * @playground chart.legendVisible
 * @playground chart.title
 * @playground chart.titleSide
 * @see javafx.scene.chart.LineChart
 * @see javafx.scene.chart.NumberAxis
 * @see javafx.scene.chart.XYChart
 * @embedded
 *
 * @related /Charts/Area/Area Chart
 * @related /Charts/Line/Category Line Chart
 * @related /Charts/Scatter/Scatter Chart
 * @related /Charts/Line/Stock Line Chart
 */
public class MyLineChart extends Application {

    public static LineChart chart;
    public static NumberAxis xAxis;
    public static NumberAxis yAxis;

    
    public static Parent createContent() {



        String delimiter = ",";
      
        List<String[]> records = new ArrayList<>();

        try{
          File file = new File("/Users/noah/github-classroom/SACHSTech/cpt-noahlin34/src/charts/data.csv");
  
          FileReader fileReader = new FileReader(file);
  
          BufferedReader reader = new BufferedReader(fileReader);
  
          String line = "";
  
          while((line = reader.readLine()) != null) {
            String[] temparr = line.split(delimiter);
            records.add(line.split(","));
          }
        } catch (IOException e) {
          e.printStackTrace();
        }

        String[][] array = new String[records.size()][3];
        records.toArray(array);





        xAxis = new NumberAxis("Year", 1980, 2020, 1);
        yAxis = new NumberAxis("Gini Coefficient", 20, 40, 1);






        XYChart.Series<Double, Double> seriesAustralia = new XYChart.Series<>();
        seriesAustralia.setName("Australia");

        chart = new LineChart<>(xAxis, yAxis);

        for(int x = 0; x < 6; x++ ) {
            XYChart.Series<Double, Double> series = new XYChart.Series<>();
            series.setName(Integer.toString(x));

            if(x == 0) {
                for(int i = 1; i < 16; i++) {
                    series.getData().add(new XYChart.Data<>(Double.parseDouble(array[i][1]), Double.parseDouble(array[i][2])));
                    series.setName("Australia");
                }
            }
            
            if (x == 1) {
                for(int i = 17; i < 55; i++) {
                    series.getData().add(new XYChart.Data<>(Double.parseDouble(array[i][1]), Double.parseDouble(array[i][2])));
                    series.setName("Canada");
                }
            }

            if(x == 2) {
                for(int i = 56; i < 64; i++ ) {
                    series.getData().add(new XYChart.Data<>(Double.parseDouble(array[i][1]), Double.parseDouble(array[i][2])));
                    series.setName("Denmark");
                }
            }



            chart.getData().add(series);
            
        }   



       



        return chart;
    }

    @Override public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    /**
     * Java main for when running without JavaFX launcher
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
