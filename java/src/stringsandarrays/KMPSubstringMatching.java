package stringsandarrays;

public class KMPSubstringMatching {

    public static void main(String[] args) {
        String text = "abcxabcdabxabcdabcdabcy";
        String pattern = "abcdabcy";
        System.out.println(new KMPSubstringMatching().solve(text, pattern));
    }

    private int solve(String text, String pattern) {
        int t = 0, p = 0;
        int[] lps = computeLPSArray(pattern);
        while (t < text.length() && p < pattern.length()) {
            if (text.charAt(t) == pattern.charAt(p)) {
                t++;
                p++;
            } else {
                if (p == 0) t++;
                else
                    p = lps[p - 1];
            }
        }

        if (p == pattern.length()) return t - p;
        return 0;
    }

    private int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];

        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[i] = j++ + 1;
            } else {
                while (j != 0 && pattern.charAt(i) != pattern.charAt(j)) {
                    j = lps[j - 1];
                }
                if (pattern.charAt(i) == pattern.charAt(j)) {
                    lps[i] = j++ + 1;
                }
            }
        }
        return lps;
    }
}
