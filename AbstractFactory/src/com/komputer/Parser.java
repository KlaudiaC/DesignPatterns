package com.komputer;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;

public class Parser{
    Map<String, Integer> data = new HashMap<>();

    Map<String, Integer> loadData(){
        File dataFile = new File("data.txt");
        try{
            Scanner scan = new Scanner(dataFile);
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                if(line.charAt(0) == 'r')
                    data.put("color", 1);
                else if(line.charAt(0) == 'b')
                    data.put("color", 2);
                else
                    data.put("color", 3);
                data.put("x", Character.getNumericValue(line.charAt(2)));
                data.put("y", Character.getNumericValue(line.charAt(4)));
                data.put("priority", Character.getNumericValue(line.charAt(6)));
            }
        }catch(FileNotFoundException e){
            System.out.println("Blad wczytywania.");
        }
        return data;
    }
}
