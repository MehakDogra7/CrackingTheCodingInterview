package InterviewBit.Strings;

public class ValidNumber {

    public static void main(String[] args) {

        //48 --- '0'
        //57 --- '9'
        System.out.println(new ValidNumber().isNumber("0") + " 1");
        System.out.println(new ValidNumber().isNumber(" 0.1  ") + " 1");
        System.out.println(new ValidNumber().isNumber("abc") + " 0");
        System.out.println(new ValidNumber().isNumber("1 a") + " 0");
        System.out.println(new ValidNumber().isNumber("2e10") + " 1");

        System.out.println(new ValidNumber().isNumber("1u") + " 0");
        System.out.println(new ValidNumber().isNumber("0.1e10") + " 1");
        System.out.println(new ValidNumber().isNumber("-01.1e-10") + " 1");
        System.out.println(new ValidNumber().isNumber("3.") + " 0");
        System.out.println(new ValidNumber().isNumber("3e0.1") + " 0");
        System.out.println(new ValidNumber().isNumber("008") + " 1");
        System.out.println(new ValidNumber().isNumber(".2") + " 1");

    }

    private int isNumber(String A) {

        String temp = skipPrecedingWhitespaces(A);
        temp = removeSucceedingZeros(temp);

        String mantissa = "";
        String exponent = "";
        int i = 0;

        for (; i < temp.length(); i++) {
            if (temp.charAt(i) == 'e' || temp.charAt(i) == 'E') {
                if (i == temp.length() - 1)
                    return 0;
                mantissa = temp.substring(0, i);
                exponent = temp.substring(i + 1);
            }
        }

        if (mantissa.isEmpty()) {
            mantissa = temp;
        }

        return isMantissaValid(mantissa) & isExponentValid(exponent);
    }

    private int isMantissaValid(String mantissa) {

        if (mantissa.isEmpty())
            return 0;

        String preDec = "";
        String postDec = "";
        boolean isDecPresent = false;
        int i = 0;
        if (mantissa.charAt(i) == '-' || mantissa.charAt(i) == '+') {
            if (mantissa.length() < 2)
                return 0;
            mantissa = mantissa.substring(1);
        }

        for (; i < mantissa.length(); i++) {
            if (mantissa.charAt(i) == '.') {
                if (isDecPresent)
                    return 0;
                isDecPresent = true;
                if (i == mantissa.length() - 1)
                    return 0;
                preDec = mantissa.substring(0, i);
                postDec = mantissa.substring(i + 1);
            }
        }

        if (!isDecPresent && preDec.isEmpty())
            preDec = mantissa;

        return isNumberValid(preDec) & (isDecPresent ? isNumberValid(postDec) : 1);
    }

    private int isExponentValid(String exponent) {

        if (exponent.isEmpty())
            return 1;

        int i = 0;
        if (exponent.charAt(i) == '-' || exponent.charAt(i) == '+') {
            if (exponent.length() < 2)
                return 0;
            exponent = exponent.substring(1);
        }

        return isNumberValid(exponent);
    }

    private int isNumberValid(String num) {

        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) < 48 || num.charAt(i) > 57)
                return 0;
        }
        return 1;
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

    private String removeSucceedingZeros(String A) {

        int i;
        for (i = A.length() - 1; i >= 0; i--) {
            if (A.charAt(i) != ' ') {
                break;
            }
        }
        return A.substring(0, i + 1);
    }
}
