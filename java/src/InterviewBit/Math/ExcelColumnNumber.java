package InterviewBit.Math;

import java.util.ArrayList;

public class ExcelColumnNumber {

    public static void main(String[] args) {
        System.out.println(getColumnName(53));
        System.out.println(new ExcelColumnNumber().titleToNumber("YZ"));
    }

    private static String getColumnName(int A) {
        StringBuilder res = new StringBuilder();

        while (A > 0) {
            int rem = A % 26;
            if (rem == 0) {
                res.append('Z');
                A = A / 26 - 1;
            } else {
                res.append((char) ((rem - 1) + 'A'));
                A = A / 26;
            }

        }
        return res.reverse().toString();
    }

    public int titleToNumber(String A) {

        int result = 0;
        ArrayList<Integer> ascii = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            ascii.add((int) A.charAt(i) - 64);
        }

        int j = ascii.size() - 1;
        for (int i = 0; i < ascii.size(); i++) {
            result += Math.pow(26, j) * ascii.get(i);
            j--;
        }

        return result;
    }
}
