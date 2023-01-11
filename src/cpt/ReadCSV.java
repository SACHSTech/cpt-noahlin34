package cpt;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;




public class ReadCSV {

    public String[][] read (String strfilePath) {
        List<String[]> listColumns = new ArrayList<>();
        String strCurrentLine = "";

        try{
            File file = new File(strfilePath);
            FileReader fileReader = new FileReader(strfilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);



            while((strCurrentLine = bufferedReader.readLine()) != null) {
                String[] arrTemp = strCurrentLine.split(",");
                listColumns.add(arrTemp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String[][] twodarrFinal = new String[listColumns.size()][3];
        listColumns.toArray(twodarrFinal);
        return twodarrFinal;
        
    }


    
}
