package InterviewBit.Strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {

        System.out.println(new RomanToInteger().convertToInteger("IV"));

    }

    private int convertToInteger(String A) {

        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int number = 0;
        boolean lastCovered = false;

        for (int i = 0; i < A.length() - 1; i++) {
            int compare = Integer.compare(
                    roman.get(A.charAt(i)),
                    roman.get(A.charAt(i + 1))
            );

            if (compare == 1 || compare == 0) {
                number += roman.get(A.charAt(i));
            } else if (compare == -1) {
                number += (roman.get(A.charAt(i + 1)) - roman.get(A.charAt(i)));
                if (i == A.length() - 2)
                    lastCovered = true;
                i++;
            }
        }

        if (!lastCovered) {
            number += roman.get(A.charAt(A.length() - 1));
        }

        return number;
    }
}
