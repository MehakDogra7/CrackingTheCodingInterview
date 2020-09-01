package InterviewBit.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class WaysToDecode {

    Map<String, Integer> dp = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new WaysToDecode().numDecodings("12345"));
    }

    public int numDecodings(String A) {
        if (A.charAt(0) == '0') return 0;
        if (A.length() <= 1) return A.length();
        if (A.length() == 2) {
            if (Integer.parseInt(A) <= 26 && Integer.parseInt(A) > 10) return 2;
            return 1;
        }

        if (dp.containsKey(A)) return dp.get(A);
        long count = 0;
        String first2 = A.substring(0, 2);
        if (Integer.parseInt(first2) <= 26) {
            count = numDecodings(A.substring(1)) % 1000000007 + numDecodings(A.substring(2)) % 1000000007;
        } else {
            count = numDecodings(A.substring(1)) % 1000000007;
        }

        int temp = (int) count % 1000000007;
        dp.put(A, temp);
        return temp;
    }
}
