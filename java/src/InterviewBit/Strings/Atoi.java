package InterviewBit.Strings;

public class Atoi {

    public static void main(String[] args) {

        //48 --- '0'
        //57 --- '9'
        System.out.println(new Atoi().atoi("-999999999999"));
    }

    public int atoi(String A) {

        int res = 0;
        String temp = skipPrecedingWhitespaces(A);
        if (temp.length() == 0)
            return 0;

        if (temp.charAt(0) == '-' || temp.charAt(0) == '+') {
            if (temp.length() < 2)
                return 0;
            res = getNum(temp.substring(1), temp.charAt(0));
        } else {
            res = getNum(temp, '+');
        }

        return res;
    }

    private int getNum(String A, char sign) {
        int res = 0, i = 0;
        boolean negative = sign == '-';
        int max = Integer.MAX_VALUE / 10;

        for (i = 0; i < A.length(); i++) {
            int ascii = A.charAt(i);
            if (ascii < 48 || ascii > 57) {
                break;
            }
        }

        A = A.substring(0, i);
        if (A.length() < 1)
            return 0;
        i = 0;
        res = Character.digit(A.charAt(i++), 10);
        while (i < A.length()) {

            if (res > max) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            res = res * 10 + Character.digit(A.charAt(i++), 10);
        }

        return negative ? -res : res;
    }

    private String skipPrecedingWhitespaces(String A) {

        int i;
        for (i = 0; i < A.length(); i++) {
            if (A.charAt(i) != ' ') {
                break;
            }
        }
        return A.substring(i);
    }
}
