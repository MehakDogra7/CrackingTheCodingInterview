package Question450.StacksAndQueues;

public class ValidSubstring {

    public static void main(String[] args) {
        String S = "()(())(";
        System.out.println(findMaxLen(S));
    }

    static int findMaxLen(String S) {
        // code here
        if (S.length() < 2) return 0;
        int left = 0, right = 0, maxLength = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') left++;
            else right++;

            if (left == right) maxLength = Math.max(maxLength, left * 2);
            else if (right > left) left = right = 0;
        }

        left = right = 0;

        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == '(') left++;
            else right++;

            if (left == right) maxLength = Math.max(maxLength, left * 2);
            else if (left > right) left = right = 0;
        }

        return maxLength;
    }
}
