package InterviewBit.Backtracking;

import java.util.ArrayList;

public class PermutationsString {

    public static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<String> B = new PermutationsString().solve("abc");
        B.forEach(i -> {
            System.out.print(i + " ");
            System.out.println();
        });
    }

    private ArrayList<String> solve(String A) {
        result.clear();
        recursive(A, "");
        return result;
    }

    private void recursive(String A, String str) {

        if (A.length() == 0) {
            result.add(str);
            return;
        }

        for (int i = 0; i < A.length(); i++) {
            String temp = A.substring(0, i) + A.substring(i + 1);
            recursive(temp, str + A.charAt(i));
        }

    }
}
