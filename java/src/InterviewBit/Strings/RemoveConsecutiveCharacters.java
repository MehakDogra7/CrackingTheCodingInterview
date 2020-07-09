package InterviewBit.Strings;

public class RemoveConsecutiveCharacters {

    public static void main(String[] args) {
        System.out.println(new RemoveConsecutiveCharacters().solve("aaabcd", 1));
    }

    private String solve(String A, int B) {

        String res = "";
        int i = 0;
        while (i < A.length()) {
            char curr = A.charAt(i);
            int count = 1, j = i + 1;
            while (j < A.length() && A.charAt(j) == curr) {
                count++;
                j++;
            }
            if (count != B) {
                res += A.substring(i, j);
            }
            i = j;
        }
        return res;
    }
}
