package InterviewBit.Strings;

import java.util.ArrayList;

public class AmazingSubarrays {

    public static void main(String[] args) {

        System.out.println(get("ABEC"));
    }

    private static int get(String A) {

        long count = 0;
        ArrayList<Character> vowel = new ArrayList<>();
        vowel.add('A');
        vowel.add('E');
        vowel.add('I');
        vowel.add('O');
        vowel.add('U');

        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');


        for (int i = 0; i < A.length(); i++) {
            if (vowel.contains(A.charAt(i))) {
                long temp = A.length() - i;
                count += temp % 10003;
                count %= 10003;
            }
        }

        return (int) (count % 10003);
    }
}
