package komputer;
import java.util.List;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class StandardSave implements AbstractSave{
    @Override
    public void saveData(List<Integer> numbers){
        try{
            PrintWriter resultFile = new PrintWriter("out.txt");
            for(Integer value: numbers)
                resultFile.print(value +" ");
            resultFile.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
