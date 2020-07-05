package InterviewBit.Strings;

public class AddBinaryStrings {

    public static void main(String[] args) {

        //48 --- '0'
        //57 --- '9'
        System.out.println(new AddBinaryStrings().addBinary("11", "11"));
    }

    public String addBinary(String A, String B) {

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
            char x = a.charAt(i);
            char y = b.charAt(i);
            char add = '0';

            if (x == '0' && y == '0') {
                add = carry ? '1' : '0';
                carry = false;
            } else if (x == '0' && y == '1') {
                add = carry ? '0' : '1';
            } else if (x == '1' && y == '0') {
                add = carry ? '0' : '1';
            } else if (x == '1' && y == '1') {
                add = carry ? '1' : '0';
                carry = true;
            }
            res.insert(0, add);
        }

        if (carry)
            res.insert(0, '1');

        return res.toString();
    }
}
