package LC400_08_BinarySearch;

/**
 * Created by Gary on 2019-02-02.
 */
public class LC278 {
    public int firstBadVersion(int n) {
        int left = 0, right = n, mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid))  right = mid;
            else                    left = mid;
        }
        if (isBadVersion(left)) return left;
        return right;
    }

    // 通过编译器
    boolean isBadVersion(int version) {
        return false;
    }
}
