package cpt;

import java.util.ArrayList;
import java.util.List;
import java.io.*;



/**
 * @author Noah Lin 
 * 
 */
public class ReadCSV {

    /**
     * 
     * This static method is used to parse a CSV file from a given file path into a 2d array. 
     * It first creates a list containing arrays to represent each column, which are then fed into a 2d array.
     * This allows us to get singular data entries from the csv file. 
     * 
     * @param strfilePath File path to the csv that gets parsed 
     * @return returns a 2d array with the values from the csv file 
     */
    public static String[][] readCSVFile (String strfilePath) {

        //declaring variables
        List<String[]> listColumns = new ArrayList<>();
        String strCurrentLine = "";
        File file = new File(strfilePath);

        
        //try catch to read the file 
        try(FileReader fileReader = new FileReader(file);){
            //initializing buffered reader  
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //keep reading files until null value, end of the file 
            while((strCurrentLine = bufferedReader.readLine()) != null) {
                
                //temp array
                String[] arrTemp = strCurrentLine.split(",");
                listColumns.add(arrTemp);
            }


        } catch (IOException e) {
            //handle exception
            e.printStackTrace();
        }

        //2fd array that takes input from the list
        String[][] twodarrFinal = new String[listColumns.size()][listColumns.get(0).length];
        listColumns.toArray(twodarrFinal);

        //return
        return twodarrFinal;



    }


    
}
