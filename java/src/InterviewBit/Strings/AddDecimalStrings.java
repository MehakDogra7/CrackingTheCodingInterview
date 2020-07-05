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
            int diff = A.length() - B.length();
            String temp = "";
            for (int i = 0; i < diff; i++) {
                temp += "0";
            }
            b = temp + b;
        }

        if (B.length() > A.length()) {
            int diff = B.length() - A.length();
            String temp = "";
            for (int i = 0; i < diff; i++) {
                temp += "0";
            }
            a = temp + a;
        }

        boolean carry = false;
        for (int i = a.length() - 1; i >= 0; i--) {
            int x = a.charAt(i) - 48;
            int y = b.charAt(i) - 48;

            if (x < 0 || x > 9 || y < 0 || y > 9)
                return "";


            int temp = x + y;
            if (carry)
                temp++;

            if (temp > 9) {
                temp -= 10;
                char add = (char) (temp + 48);
                res.insert(0, add);
                carry = true;
            } else {
                char add = (char) (temp + 48);
                res.insert(0, add);
                carry = false;
            }
        }

        if (carry)
            res.insert(0, 1);

        return res.toString();
    }
}
