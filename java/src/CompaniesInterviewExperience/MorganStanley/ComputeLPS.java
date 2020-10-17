package CompaniesInterviewExperience.MorganStanley;

/**
 * Longest prefix which is also suffix
 * <p>
 * |--|~ |--|
 * a b c a b y ---> ab is a prefix and ab is also there at the end ( part of 1 suffix)
 * 0 0 0 1 2 0
 * |----|~|----| |-|
 * a b c d a b c a
 * 0 0 0 0 1 2 3 1
 */
public class ComputeLPS {

    public static void main(String[] args) {
        int[] temp = computeLPS("abcaby");
        for (int i : temp) {
            System.out.print(i + " ");
        }
        System.out.println();
        temp = computeLPS("abcdabca");
        for (int i : temp) {
            System.out.print(i + " ");
        }
        System.out.println();
        temp = computeLPS("acacabacacabacacac");
        for (int i : temp) {
            System.out.print(i + " ");
        }
        System.out.println();
        temp = computeLPS("aaaa");
        for (int i : temp) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] computeLPS(String pattern) {
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
