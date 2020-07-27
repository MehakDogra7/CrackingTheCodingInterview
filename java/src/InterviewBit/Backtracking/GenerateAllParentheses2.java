package InterviewBit.Backtracking;

import java.util.ArrayList;

public class GenerateAllParentheses2 {

    public static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<String> B = new GenerateAllParentheses2().generateParenthesis(3);
        B.forEach(i -> System.out.print(i + " "));
    }

    public ArrayList<String> generateParenthesis(int A) {
        result.clear();
        recursive(A, "", 0, 0);

        return result;
    }

    private void recursive(int A, String str, int openTillNow, int currLen) {
        if (currLen >= 2 * A) {
            if (openTillNow == 0) {
                result.add(str);
            }
            return;
        }

        recursive(A, str + '(', openTillNow + 1, currLen + 1);
        if (openTillNow > 0)
            recursive(A, str + ')', openTillNow - 1, currLen + 1);
    }
}
