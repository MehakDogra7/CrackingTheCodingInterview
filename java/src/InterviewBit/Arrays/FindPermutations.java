package InterviewBit.Arrays;

import java.util.ArrayList;

public class FindPermutations {

    public static void main(String[] args) {

        findPermutation("DDDIII", 7).forEach(i -> System.out.print(i + " "));
    }

    private static ArrayList<Integer> findPermutation(final String A, int B) {

        ArrayList<Integer> result = new ArrayList<>();
        int start = 1;
        int end = B;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'I')
                result.add(start++);
            else
                result.add(end--);
        }

        result.add(start);

        return result;
    }
}
