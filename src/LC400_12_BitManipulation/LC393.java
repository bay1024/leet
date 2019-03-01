package LC400_12_BitManipulation;

/**
 * Created by Gary on 2019-02-26.
 */
public class LC393 {
    public boolean validUtf8(int[] data) {
        int len = data.length;
        for (int i = 0; i < len; i++) {
            int current = data[i];
            int type = getType(current);
            if (type == 0) continue;
            else if (type > 1 && i + type <= len) {
                while (type-- > 1) {
                    if (getType(data[++i]) != 1) return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    int[] marks = {128, 64, 32, 16, 8};

    private int getType(int current) {
        for (int i = 0; i < 5; i++) {
            if ((marks[i] & current) == 0) {
                return i;
            }
        }
        return -1;
    }
}
