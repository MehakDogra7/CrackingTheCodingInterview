package Question450.Heap;

public class ReorganizeString {

    public static void main(String[] args) {
        String S = "vvvlo";
        System.out.println(new ReorganizeString().reorganizeString(S));
    }

    public String reorganizeString(String S) {
        int[] count = new int[26];

        for (int i = 0; i < S.length(); i++) {
            count[(int) (S.charAt(i) - 97)]++;
        }

        int max = 0, maxLetter = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                maxLetter = i;
            }
        }

        int n = S.length(), r = 0;
        if (max > (n + 1) / 2) return "";

        char[] res = new char[n];

        while (count[maxLetter] > 0) {
            res[r] = ((char) (maxLetter + 97));
            count[maxLetter]--;
            r += 2;
        }

        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                if (r >= n) r = 1;
                res[r] = ((char) (i + 97));
                r += 2;
                count[i]--;
            }
        }


        return String.valueOf(res);
    }
}
