package LC400_03_Math;

/**
 * Created by Gary on 2019-02-27.
 */
public class Math08_LC_29 {
    public int divide(int dividend, int divisor) {
        int sign = 1;// store the sign of the result;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;

        // change to positive long integer to make it easier
        long dend = Math.abs((long) dividend), dsor = Math.abs((long) divisor);
        // deal with the edge cases
        if (dsor == 0) return Integer.MAX_VALUE;
        if (dend == 0) return 0;

        long answer = div(dend, dsor);
        int result;
        if (answer > Integer.MAX_VALUE)
            result = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        else
            result = (int) (answer * sign);
        return result;
    }

    private long div(long dend, long dsor) {
        if (dend < dsor) return 0;// recursion exit condition

        long sum = dsor;
        long mul = 1;
        while (sum + sum <= dend) {
            sum += sum;
            mul += mul;
        }
        return mul + div(dend - sum, dsor);
    }
}
