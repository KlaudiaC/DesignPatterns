package komputer;
import java.util.List;
import java.util.Collections;

public class StandardSort implements AbstractSort{
    @Override
    public List<Integer> sortValues(List<Integer> numbers){
        Collections.sort(numbers);
        return numbers;
    }
}
