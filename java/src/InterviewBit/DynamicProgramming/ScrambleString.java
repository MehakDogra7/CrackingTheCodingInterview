package InterviewBit.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {
    Map<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        String A = "great";
        String B = "rgeat";

        System.out.println(new ScrambleString().solveTopDown(A, B));
    }

    //TODO: Do it in Bottom Up manner
    public int solveBottomUp(String A, String B) {
        Map<String, Boolean> dp = new HashMap<>();

        return 1;
    }

    public int isScramble(String A, String B) {
        if (A.equals(B)) return 1;
        return solveTopDown(A, B) ? 1 : 0;
    }

    private boolean solveTopDown(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.length() == 0) return false;
        if (A.equals(B)) return true;

        String key = A + "_" + B;
        if (map.containsKey(key)) return map.get(key);
        int n = A.length();

        boolean curr = false;
        for (int i = 1; i < n; i++) {
            curr = (solveTopDown(A.substring(0, i), B.substring(n - i)) &&
                    solveTopDown(A.substring(i), B.substring(0, n - i))) ||
                    (solveTopDown(A.substring(0, i), B.substring(0, i)) &&
                            solveTopDown(A.substring(i), B.substring(i)));
            if (curr) break;
        }
        map.put(key, curr);
        return curr;
    }

}
