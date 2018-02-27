package komputer;
import java.util.List;

public class Strategy{
    AbstractRead read;
    AbstractSort sort;
    AbstractSave save;

    public void setRead(AbstractRead read){
        this.read = read;
    }

    public void setSort(AbstractSort sort){
        this.sort = sort;
    }

    public void setSave(AbstractSave save){
        this.save = save;
    }

    public void doWork(String file){
        List<Integer> numbers = read.readData(file);
        numbers = sort.sortValues(numbers);
        save.saveData(numbers);
    }
}
