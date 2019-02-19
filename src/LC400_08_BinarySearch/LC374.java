package LC400_08_BinarySearch;

/**
 * Created by Gary on 2019-02-05.
 */
public class LC374 {

    public int guessNumber(int n) {
        int left = 1, right = n, mid;
        while (left + 1 < right) {
            mid = left + ((right - left) >> 1);
            int result = guess(mid);
            if (result == 0)    return mid;
            else if (result == 1) left = mid;
            else right = mid;
        }
        if (guess(left) == 0)   return left;
        if (guess(right) == 0)  return right;
        return -1;
    }
    // 通过编译器
    private int guess(int number) { return 0; }
}
