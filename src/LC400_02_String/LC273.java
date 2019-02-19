package LC400_02_String;

/**
 * Created by Gary on 11/13/18.
 */
public class LC273 {
    public String numberToWords(int num) {
        if (num < 0) return "";
        if (num == 0) return "Zero";
        //左起段落
        int segment1 = num / 1000000000;           //段落1：十亿位-千亿位
        int segment2 = num % 1000000000 / 1000000; //段落2：百万位-亿位
        int segment3 = num % 1000000 / 1000;       //段落3：千位-十万位
        int segment4 = num % 1000;                 //段落4：个位-百位

        String result = "";
        if (segment1 > 0) result += convert(segment1) + " " + "Billion ";
        if (segment2 > 0) result += convert(segment2) + " " + "Million ";
        if (segment3 > 0) result += convert(segment3) + " " + "Thousand ";
        if (segment4 > 0) result += convert(segment4);
        return result.trim();
    }

    private String convert(int num) {
        String res = "";
        String[] ten = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] hundred = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] twenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        if (num > 0) {
            int temp = num / 100;
            if (temp > 0) res += ten[temp] + " Hundred";
            temp = num % 100;
            if (temp >= 10 && temp < 20) {
                if (!res.isEmpty()) res += " ";
                res = res + twenty[temp % 10];
                return res;
            } else if (temp >= 20) {
                temp = temp / 10;
                if (!res.isEmpty()) res += " ";
                res = res + hundred[temp - 1];
            }
            temp = num % 10;
            if (temp > 0) {
                if (!res.isEmpty()) res += " ";
                res = res + ten[temp];
            }
        }
        return res;
    }
}
