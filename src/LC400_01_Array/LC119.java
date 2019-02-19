package LC400_01_Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gary on 12/1/18.
 */
public class LC119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        long col = 1;
        for (int j = 0; j <= rowIndex; j++) {
            result.add((int)col);
            col *= rowIndex - j;
            col /= j + 1;
        }
        return result;
    }
}
