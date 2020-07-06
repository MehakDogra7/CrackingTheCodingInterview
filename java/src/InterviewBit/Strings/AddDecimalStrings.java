package InterviewBit.Strings;

public class AddDecimalStrings {

    public static void main(String[] args) {

        //48 --- '0'
        //57 --- '9'
        System.out.println(add("999", "323"));
    }

    private static String add(String A, String B) {

        StringBuilder res = new StringBuilder();
        String a = new String(A);
        String b = new String(B);

        if (A.length() > B.length()) {
            b = appendZeros(b, A.length() - b.length());
        }

        if (B.length() > A.length()) {
            a = appendZeros(a, B.length() - A.length());
        }

        boolean carry = false;
        for (int i = a.length() - 1; i >= 0; i--) {
            int x = a.charAt(i) - 48;
            int y = b.charAt(i) - 48;
            if (x < 0 || x > 9 || y < 0 || y > 9)
                return "";

            int temp = carry ? (x + y + 1) : (x + y);

            if (temp > 9) {
                temp -= 10;
                carry = true;
            } else {
                carry = false;
            }

            res.insert(0, temp);
        }

        if (carry)
            res.insert(0, 1);

        return res.toString();
    }

    private static String appendZeros(String str, int diff) {
        while (diff > 0) {
            str = "0" + str;
            diff--;
        }
        return str;
    }
}
