package InterviewBit.Strings;

public class ZigZagString {

    public static void main(String[] args) {
        System.out.println(new ZigZagString().convert("ABCD", 3));
    }

    public String convert(String A, int B) {

        if (B == 1) {
            return A;
        }
        String array[] = new String[B];

        for (int i = 0; i < array.length; i++) {
            array[i] = "";
        }

        String res = "";
        int row = 0;
        int direction = 0;
        //0--down
        //1-up

        for (int i = 0; i < A.length(); i++) {
            array[row] = array[row] + String.valueOf(A.charAt(i));
            if (row == 0) {
                direction = 0;
            } else if (row == B - 1) {
                direction = 1;
            }
            if (direction == 0) {
                row++;
            } else {
                row--;
            }
        }

        for (int i = 0; i < array.length; i++) {
            res += array[i];
        }

        return res;
    }
}
