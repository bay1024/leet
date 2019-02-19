package LC400_01_Array;

/**
 * Created by Gary on 11/25/18.
 */
class Relation {
    /**
     * 判断i 和 j 是否认识。这里只是空方法，供solution使用
     */
    boolean knows(int i, int j){
        // todo:: 实现方法
        return false;
    }
}
public class LC277 extends Relation{
    /* celebrity 条件很特殊，所有人都认识他，他不认识其他任何人。
     * brute force 遍历 复杂度是 n^2，要降低复杂度就要利用好第一个条件。
     * 解法：两遍遍历。第一遍找出可能的celebrity，第二遍检验是否是celebrity
     */
    public int findCelebrity(int n) {
        int candidate = 0;  // 初始假设celebrity 是 0
        // 第一遍遍历，从1号到最后一个
        for (int i = 1; i < n; i++) {
            // 如果当前candidate认识i，则当前candidate肯定不是真正的celebrity，i就可能是
            // 把当前的candidate置为i
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        //  此时candidate有两种情况：
        //  1.可能是celebrity，返回candidate
        //  2.也可能不是（这种情况就是不存在celebrity），返回-1
        for (int i = 0; i < n; i++) {
            // 遍历找不存在的情况
            // 判断条件：1.当前i不是candidate本人；
            //         2.candidate认识i，或者i不认识candidate 都不满足celebrity条件
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) {
                return -1;
            }
        }
        return candidate;
    }
}
