package InterviewBit.Strings;

public class Palindrome {

    public static void main(String[] args) {

        System.out.println(isPal("A man, a plan, a canal: Panama"));
    }

    private static int isPal(String A) {

        int i = 0;
        int j = A.length() - 1;

        while (i < A.length() && j >= 0) {

            if (!((A.charAt(i) >= 'a' && A.charAt(i) <= 'z') ||
                    (A.charAt(i) >= '0' && A.charAt(i) <= '9') ||
                    (A.charAt(i) >= 'A' && A.charAt(i) <= 'Z'))) {
                i++;
                continue;
            }
            if (!((A.charAt(j) >= 'a' && A.charAt(j) <= 'z') ||
                    (A.charAt(j) >= '0' && A.charAt(j) <= '9') ||
                    (A.charAt(j) >= 'A' && A.charAt(j) <= 'Z'))) {
                j--;
                continue;
            }

            if (!(A.charAt(i) == A.charAt(j) ||
                    A.charAt(i) + 32 == A.charAt(j) ||
                    A.charAt(i) == A.charAt(j) + 32 ||
                    A.charAt(i) + 32 == A.charAt(j) + 32)) {
                return 0;
            }
            i++;
            j--;

        }

        return 1;
    }
}
