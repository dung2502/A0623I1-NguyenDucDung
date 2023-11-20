package javaIO.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {
    public static final String FILE_PATH = "E:\\Code_Gym\\Module2\\Code_Module2\\src\\javaIO\\read\\country.csv";
    public static List<Country> ReadCountry(){
        List<Country> countryList = new ArrayList<>();
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader buffer = new BufferedReader(new FileReader(file));


            String line;
            String temp[];
            Country country;
            while((line = buffer.readLine()) != null){
                temp = line.split(",");
                int id = Integer.parseInt(temp[0]);
                String code = temp[1];
                String name = temp[2];

                country = new Country(id, code, name);
                countryList.add(country);
            }
            buffer.close();

        }
        catch (Exception e){
            System.out.println("Have A Bug");
        }
        return countryList;
    }

    public static void main(String[] args) {
        List<Country> countryList = ReadCountry();
        for ( Country c: countryList){
            System.out.println(c + "\n");
        }
    }
}
