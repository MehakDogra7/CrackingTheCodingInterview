package CompaniesInterviewExperience.MorganStanley;

public class IsSubstring {

    public static void main(String[] args) {
        String data = "abcxabcdabxabcdabcdabcy";
        String pattern = "abcdabcy";
        System.out.println(new IsSubstring().solve(data, pattern));
    }

    private int solve(String data, String pattern) {

        //compute LPS array for pattern
        int[] lps = computeLPS(pattern);
        int d = 0, p = 0;
        while (d < data.length() && p < pattern.length()) {
            if (data.charAt(d) == pattern.charAt(p)) {
                d++;
                p++;
            } else {
                if (p == 0) d++;
                else p = lps[p - 1];
            }
        }

        return d - p;
    }

    private int[] computeLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];

        int i = 1, j = 0;
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(j)) {       //if match then lps will be j+1 and inc both
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {       //Keep decrementing (exponentially) "j" until either j becomes zero or we see both char i == j
                    j = lps[j - 1];
                }
                if (pattern.charAt(i) == pattern.charAt(j)) {                   //if char i == j then update lps and inc j
                    lps[i] = j + 1;
                    j++;
                }
                i++;                                                            //Inc i as well if i == j matched then lps would already have updated otherwise it will remain 0
            }
        }
        return lps;
    }
}
