package InterviewBit.Strings;

public class ConvertToPalindrome {
    public static void main(String[] args) {
        System.out.println(new ConvertToPalindrome().isPossible("abbca"));
    }

    private int isPossible(String A) {

        int i = 0, j = A.length() - 1;
        boolean foundMisMatch = false;
        while (i < j) {
            if (A.charAt(i) == A.charAt(j)) {
                i++;
                j--;
            } else {
                if (foundMisMatch)
                    return 0;
                foundMisMatch = true;
                if (A.charAt(i) == A.charAt(j - 1)) {
                    i++;
                    j -= 2;
                } else if (A.charAt(i + 1) == A.charAt(j)) {
                    i += 2;
                    j--;
                }
            }
        }

        return 1;
    }
}
