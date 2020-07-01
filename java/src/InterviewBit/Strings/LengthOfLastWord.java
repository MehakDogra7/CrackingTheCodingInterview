package InterviewBit.Strings;

public class LengthOfLastWord {

    public static void main(String[] args) {

        System.out.println(length("Hello ")); //5
        System.out.println(length("Hello   ")); //5
        System.out.println(length(" Hello ")); //5
        System.out.println(length(" Hello"));  //5
        System.out.println(length("Hello"));  //5
        System.out.println(length("Hello Worlds"));  //6
        System.out.println(length(" "));  //0
    }

    private static int length(String A) {

        boolean foundAChar = false;
        int startIndex = A.length() - 1;
        for (int i = A.length() - 1; i >= 0; i--) {

            if (!foundAChar && A.charAt(i) != ' ') {
                foundAChar = true;
                startIndex = i;
            }

            if (!foundAChar) {
                continue;
            }

            if (A.charAt(i) == ' ') {
                return startIndex - i;
            }
            if (i == 0) {
                return startIndex + 1;
            }
        }

        return 0;
    }
}
