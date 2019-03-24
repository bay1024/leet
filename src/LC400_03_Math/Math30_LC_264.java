package LC400_03_Math;

/**
 * Created by Gary on 2019-03-03.
 */
public class Math30_LC_264 {
    public int nthUglyNumber(int n) {
        int[] numbers = new int[n];
        int index2 = 0, index3 = 0, index5 = 0;
        numbers[0] = 1;
        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = Math.min(numbers[index2] * 2, Math.min(numbers[index3] * 3, numbers[index5] * 5));
            if (numbers[i] == numbers[index2] * 2) index2++;
            if (numbers[i] == numbers[index3] * 3) index3++;
            if (numbers[i] == numbers[index5] * 5) index5++;
        }
        return numbers[n - 1];
    }
}
