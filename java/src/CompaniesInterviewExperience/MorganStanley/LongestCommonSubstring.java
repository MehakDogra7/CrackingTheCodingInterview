package CompaniesInterviewExperience.MorganStanley;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String A = "GexksforGeeks";
        String B = "AGeeksQuiz";

        System.out.println(new LongestCommonSubstring().solve(A, B));
    }

    private int solve(String A, String B) {

        int[][] dp = new int[A.length() + 1][B.length() + 1];
        int max = Integer.MIN_VALUE, maxI = -1, maxJ = -1;

        for (int i = 1; i < A.length() + 1; i++) {
            for (int j = 1; j < B.length() + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                if (dp[i][j] > max) {
                    max = Math.max(max, dp[i][j]);
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        StringBuilder lcsString = new StringBuilder();
        while (dp[maxI][maxJ] != 0) {
            lcsString.insert(0, A.charAt(maxI - 1));
            maxI--;
            maxJ--;
        }

        System.out.println(lcsString);
        return max;
    }
}
