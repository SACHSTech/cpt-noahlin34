package cpt;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;




public class ReadCSV {

    public static String[][] readCSVFile (String strfilePath) {
        List<String[]> listColumns = new ArrayList<>();
        String strCurrentLine = "";
        File file = new File(strfilePath);

        try(FileReader fileReader = new FileReader(file);){
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            while((strCurrentLine = bufferedReader.readLine()) != null) {
                String[] arrTemp = strCurrentLine.split(",");
                listColumns.add(arrTemp);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        String[][] twodarrFinal = new String[listColumns.size()][listColumns.get(0).length];
        listColumns.toArray(twodarrFinal);
        return twodarrFinal;



    }


    
}
