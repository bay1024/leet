package LC400_01_Array;

/**
 * Created by Gary on 11/28/18.
 */
public class LC299 {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] count = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bulls++;
            } else {
                int numS = s - '0';
                int numG = g - '0';
                if (count[numS] < 0) cows++;
                if (count[numG] > 0) cows++;
                count[numS]++;
                count[numG]--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
