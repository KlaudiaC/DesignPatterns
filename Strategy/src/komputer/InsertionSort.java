package komputer;
import java.util.List;
import java.util.Arrays;

public class InsertionSort implements AbstractSort{
    @Override
    public List<Integer> sortValues(List<Integer> listNumbers){
        Integer[] arrayNumbers = new Integer[listNumbers.size()];
        arrayNumbers = listNumbers.toArray(arrayNumbers);

        for(int i = 1; i < arrayNumbers.length; i++){
            int n = arrayNumbers[i];
            int j = i - 1;

            while(j >= 0 && n < arrayNumbers[j]){
                arrayNumbers[j + 1] = arrayNumbers[j];
                j--;
            }
            arrayNumbers[j + 1] = n;
        }
        return Arrays.asList(arrayNumbers);
    }
}
