package CompaniesInterviewExperience.Walmart;

import java.util.HashMap;
import java.util.Map;

public class FakePalindrome {

    public static void main(String[] args) {
        String A = "ABAB";
        System.out.println(new FakePalindrome().solveNSquare(A));
        System.out.println(new FakePalindrome().solveN(A));
    }

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     *
     * @param A
     * @return
     */
    private int solveNSquare(String A) {
        int n = A.length(), count = 0;

        for (int i = 0; i < n; i++) {
            int X = 0;
            for (int j = i; j < n; j++) {
                char curr = A.charAt(j);
                X = X ^ (1 << (curr - 'A'));
                if ((X & (X - 1)) == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param A
     * @return
     */
    private int solveN(String A) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int X = 0, count = 0;

        for (int i = 0; i < A.length(); i++) {
            char curr = A.charAt(i);
            X = X ^ (1 << (curr - 'A'));
            count += map.getOrDefault(X, 0);

            for (int j = 0; j < 26; j++)
                count += map.getOrDefault(X ^ (1 << j), 0);

            if (map.containsKey(X))
                map.put(X, map.get(X) + 1);
            else
                map.put(X, 1);
        }
        return count;
    }
}
