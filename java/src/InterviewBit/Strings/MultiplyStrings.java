package InterviewBit.Strings;

public class MultiplyStrings {

    public static void main(String[] args) {

        System.out.println(new MultiplyStrings().multiply("5131848155574784703269632922904933776792735241197982102373370", "56675688419586288442134264892419611145485574406534291250836"));
        System.out.println(new MultiplyStrings().multiply("12", "10"));
    }

    public String multiply(String A, String B) {

        A = removePrecedingZeros(A);
        B = removePrecedingZeros(B);

        if (A.length() == 0 || B.length() == 0)
            return "0";

        String res = "";
        for (int i = B.length() - 1; i >= 0; i--) {
            int n = B.charAt(i) - 48;
            String temp = mul(A, n);
            int numOfX = (B.length() - 1) - i;
            while (numOfX > 0) {
                temp += "0";
                numOfX--;
            }
            res = add(res, temp);
        }

        res = removePrecedingZeros(res);
        return res;
    }

    private String mul(String str, int n) {
        String res = "";
        int carry = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            int val = str.charAt(i) - 48;
            int temp = val * n + carry;
            if (i == 0) {
                res = String.valueOf(temp) + res;
                break;
            }
            if (temp > 9) {
                res = String.valueOf(temp % 10) + res;
                carry = temp / 10;
            } else {
                res = String.valueOf(temp) + res;
                carry = 0;
            }
        }
        return res;
    }

    private String add(String A, String B) {

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

    private String makeItTwice(String str, String orig) {
        StringBuilder res = new StringBuilder();
        boolean carry = false;

        if (str.length() > orig.length()) {
            int diff = str.length() - orig.length();
            for (int i = 0; i < diff; i++) {
                orig = "0" + orig;
            }
        }

        for (int i = str.length() - 1; i >= 0; i--) {
            int val1 = str.charAt(i) - 48;
            int val2 = orig.charAt(i) - 48;

            int result = val1 + val2;
            if (carry)
                result++;

            if (result > 9) {
                res.insert(0, (result - 10));
                carry = true;
            } else {
                res.insert(0, result);
                carry = false;
            }
        }

        if (carry) {
            res.insert(0, 1);
        }

        return res.toString();
    }

    public String add1(String str) {

        if (str.length() == 1) {
            return String.valueOf(Integer.parseInt(str) + 1);
        }

        int last = str.charAt(str.length() - 1) - 48;
        if (last == 9) {
            return add1(str.substring(0, str.length() - 1)) + "0";
        }

        return str.substring(0, str.length() - 1) + (last + 1);

    }
}
