package komputer;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class StandardRead implements AbstractRead{
    @Override
    public List<Integer> readData(String fileName){
        List<Integer> numbers = new ArrayList<>();
        File dataFile = new File(fileName);

        try{
            Scanner scan = new Scanner(dataFile);
            while(scan.hasNextLine())
                numbers.add(scan.nextInt());
        }catch(FileNotFoundException e){
            System.out.println("Blad wczytywania.");
        }
        return numbers;
    }
}
