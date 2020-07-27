package InterviewBit.Backtracking;

import java.util.ArrayList;

public class PalindromePartitioning {

    public static ArrayList<ArrayList<String>> result = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> B = new PalindromePartitioning().partition("aabb");
        B.forEach(i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });
    }

    public ArrayList<ArrayList<String>> partition(String a) {
        result.clear();
        recursive(a, 0, new ArrayList<>());
        return result;
    }

    private void recursive(String A, int i, ArrayList<String> list) {
        if (i >= A.length()) {
            result.add(list);
            return;
        }

        for (int j = i + 1; j <= A.length(); j++) {
            if (i == 0) {
                list = new ArrayList<>();
            }
            String curr = A.substring(i, j);
            if (isPalindrome(curr)) {
                ArrayList<String> temp = new ArrayList<>(list);
                temp.add(curr);
                recursive(A, j, temp);
            }
        }
    }

    public boolean isPalindrome(String str) {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j))
                return false;
        }
        return true;
    }
}
