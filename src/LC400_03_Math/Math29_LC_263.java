package LC400_03_Math;

/**
 * Created by Gary on 2019-03-03.
 */
public class Math29_LC_263 {
    //time: O(n)线性， space: O(1)
    public boolean isUgly(int num) {
        if (num == 0) return false;
        if (num == 1) return true;
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
    }
}
