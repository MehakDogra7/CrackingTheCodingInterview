package InterviewBit.Strings;

public class PowerOf2 {

    public static void main(String[] args) {

        System.out.println(new PowerOf2().isPowerOf2(1024));
        System.out.println(new PowerOf2().power("1024"));
    }

    private int isPowerOf2(long A) {

        if (A % 2 != 0)
            return 0;

        while (A > 0) {
            long val = A % 2;
            if (val == 1)
                break;
            A >>= 1;
        }

        if (A == 1) {
            return 1;
        }

        return 0;
    }

    public int power(String A) {

        if (A.length() == 0) {
            return 0;
        }

        if (A.length() == 1) {
            char x = A.charAt(0);
            if (x == '2' || x == '4' || x == '8') {
                return 1;
            }
            return 0;
        }

        boolean borrow = false;
        while (A.length() > 1) {

            int x = A.charAt(A.length() - 1) - 48;
            if (x % 2 != 0) {
                return 0;
            }

            String temp = "";
            for (int i = 0; i < A.length(); i++) {
                int val = A.charAt(i) - 48;
                if (borrow) {
                    val = val + 10;
                }
                val >>= 1;
                temp = temp + val;

                if (A.charAt(i) % 2 != 0) {
                    borrow = true;
                } else {
                    borrow = false;
                }
            }
            A = removePrecedingZeros(temp);
        }

        char x = A.charAt(0);
        if (x == '1' || x == '2' || x == '4' || x == '8') {
            return 1;
        }

        return 0;
    }

    private String removePrecedingZeros(String x) {

        String str = "";
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) != '0') {
                str += x.substring(i);
                break;
            }
        }
        return str;
    }
}
