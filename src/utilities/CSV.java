package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSV {
    // this function will read data from a csv file and return as a list
    public static List<String[]> read(String file) {
        List<String[]> res = new LinkedList<>();
        String dataRow;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((dataRow = br.readLine()) != null){
                String[] dataRecords = dataRow.split(",");
                res.add(dataRecords);
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
