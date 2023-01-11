package cpt;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;




public class ReadCSV {

    public Array[][] read (String strfilePath) {

        try{
            File file = new File(strfilePath);

            FileReader fileReader = new FileReader(strfilePath);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String strCurrentLine = "";

            List<String[]> listColumns = new ArrayList<>();

            while((strCurrentLine = bufferedReader.readLine()) != null) {
                String[] arrTemp = strCurrentLine.split(",");
                listColumns.add(arrTemp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    
}
