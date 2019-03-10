package LC400_03_Math;

/**
 * Created by Gary on 2019-02-27.
 */
public class Math10_LC_50 {
    public double myPow(double x, int n) {
        if (n == 0) return 1; // 如果指数是0，任何数的0次方都是1
        if (n == 1) return x; // 如果指数是1，返回底数
        int t = n / 2;        // t = 指数/2
        if (n < 0) {          // 指数如果是负数
            t = -t;           // t 变为正数
            x = 1 / x;        // 把底数变为倒数，再计算
        }
        double res = myPow(x, t);   // 降低规模后递归，计算结果
        if (n % 2 == 0) return res * res;  // 如果指数是偶数，返回结果的平方
        return res * res * x;              // 如果指数是基数，返回结果的平方再多乘一次底数
    }
}
