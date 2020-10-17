package CompaniesInterviewExperience.MorganStanley;

public class RotatedLongestCommonPrefix {

    public static void main(String[] args) {
        String A = "ababc";
        String B = "bmabxaba";
        System.out.println(new RotatedLongestCommonPrefix().solve(A, B));
        System.out.println(new RotatedLongestCommonPrefix().solveOptimal(A, B));
    }

    private int solveOptimal(String A, String B) {

        String B2 = B + B;
        int[] lps = computeLPS(B2);

        int i = 0, j = 0, max = Integer.MIN_VALUE;
        while (i < B2.length()) {
            while (j > 0 && A.charAt(j) != B2.charAt(i)) {
                j = lps[j - 1];
            }
            if (j < A.length() && A.charAt(j) == B2.charAt(i)) {
                j++;
            }

            max = Math.max(max, j);
            i++;
        }

        System.out.println(A.substring(0, max));
        return max;
    }


    private int[] computeLPS(String s) {
        int[] lps = new int[s.length()];

        int j = 0, i = 1;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                while (j > 0 && s.charAt(i) != s.charAt(j)) {
                    j = lps[j - 1];
                }
                if (s.charAt(i) == s.charAt(j)) {
                    lps[i] = j + 1;
                    j++;
                }
                i++;
            }
        }
        return lps;
    }

    private int solve(String A, String B) {
        String B2 = B + B;
        int max = Integer.MIN_VALUE;

        int i = 0;
        for (int j = 1; j <= A.length(); j++) {
            String temp = A.substring(i, j);
            int index = B2.indexOf(temp);
            if (index != -1)
                max = Math.max(max, temp.length());
        }

        return max;
    }
}
