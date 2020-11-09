package CompaniesInterviewExperience.Walmart;

public class CountAllPalindromeSubstrings {

    public static void main(String[] args) {
        String A = "abbaeae";
        System.out.println(new CountAllPalindromeSubstrings().solveNSquare(A));
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
            count += expand(A, i, i);
            count += expand(A, i, i + 1);
        }

        return count;
    }

    private int expand(String A, int left, int right) {
        int count = 0;
        while (left >= 0 && right < A.length() && A.charAt(left) == A.charAt(right)) {
            if ((right - left + 1) > 1)
                count++;
            left--;
            right++;
        }

        return count;
    }
}
