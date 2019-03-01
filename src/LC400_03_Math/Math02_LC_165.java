package LC400_03_Math;

/**
 * Created by Gary on 2019-02-27.
 */
public class Math02_LC_165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int index1 = 0;
        int index2 = 0;
        while (index1 < v1.length && index2 < v2.length) {
            int temp1 = Integer.valueOf(v1[index1]);
            int temp2 = Integer.valueOf(v2[index2]);
            if (temp1 < temp2)
                return -1;
            if (temp1 > temp2)
                return 1;
            index1++;
            index2++;
        }
        if (v1.length == v2.length)
            return 0;
        else if (v1.length > v2.length) {
            for (int i = index1; i < v1.length; i++) {
                int t = Integer.valueOf(v1[i]);
                if (t != 0)
                    return 1;
            }
            return 0;
        } else {
            for (int i = index2; i < v2.length; i++) {
                int t = Integer.valueOf(v2[i]);
                if (t != 0)
                    return -1;
            }
            return 0;
        }
    }
}
