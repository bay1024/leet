package LC400_01_Array.SUB;

/**
 */
public class LC47 {

    public String shortestPalindrome(String s) {
        String temp = s + "#" + new StringBuilder(s).reverse();
        int[] table = getTable(temp);
        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }

    private int[] getTable(String s) {
        // get lookup table
        int[] table = new int[s.length()];
        // pointer that points to matched char in prefix part
        int index = 0;
        // skip index 0, we will not match a LC400_02_String with itself
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(index) == s.charAt(i)) {
                // we can extend match in prefix and postfix
                table[i] = table[i - 1] + 1;
                index++;
            } else {
                // match failed, we try to match a shorter substring
                // by assigning index to table[i-1], we will shorten the length of the match LC400_02_String,
                // and jump to the prefix part that we used to match postfix ended at i - 1
                index = table[i - 1];
                while (index > 0 && s.charAt(index) != s.charAt(i)) {
                    // we will try to shorten the match LC400_02_String length until we revert
                    // to the beginning of match (index 1)
                    index = table[index - 1];
                }
                // when we are here may either found a match char or we reach the boundary andstil no luck
                // so we need check char match
                if (s.charAt(index) == s.charAt(i)) {
                    // if match, then extend one char
                    index++;
                }
                table[i] = index;
            }
        }
        return table;
    }
}
