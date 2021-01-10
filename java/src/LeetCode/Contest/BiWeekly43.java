package LeetCode.Contest;

import java.util.Stack;

public class BiWeekly43 {
    int sum = 0;

    /**
     * "aabbaaxybbaabb"
     * 5
     * 4
     */

    public static void main(String[] args) {
        //System.out.println(new Temp().totalMoney(4));
        //System.out.println(new Temp().maximumGain("cdbcbbaaabab", 4, 5));
        int[] res = new BiWeekly43().constructDistancedSequence(3);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public int totalMoney(int n) {
        int sum = 0;
        int temp = n / 7;
        for (int i = 1; i <= temp; i++) {
            sum += ((i + (i + 6)) * 7) / 2;
        }
        if (n % 7 != 0) {
            int a = temp + 1;
            int d = a + n % 7 - 1;
            sum += (n % 7 * (a + d)) / 2;
        }

        return sum;
    }

    public int maximumGain(String s, int x, int y) {
        if (x < y) {
            removeAB(removeBA(s, y), x);
        } else {
            removeBA(removeAB(s, x), y);
        }
        return sum;
    }

    private String removeBA(String s, int y) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' && !stack.isEmpty() && stack.peek() == 'b') {
                sum += y;
                stack.pop();
            } else {
                stack.add(s.charAt(i));
            }
        }

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }

    private String removeAB(String s, int x) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b' && !stack.isEmpty() && stack.peek() == 'a') {
                sum += x;
                stack.pop();
            } else {
                stack.add(s.charAt(i));
            }
        }

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }

    public int[] constructDistancedSequence(int n) {

        int[] ans = new int[2 * n - 1];
        int[] count = new int[n + 1];

        count[1] = 1;
        for (int i = 2; i < n + 1; i++) count[i] = 2;

        solve(0, n, ans, count);
        return ans;
    }

    private boolean solve(int index, int n, int[] ans, int[] count) {

        if (index == ans.length) return true;

        if (ans[index] != 0) return solve(index + 1, n, ans, count);

        for (int i = n; i >= 1; i--) {
            if (i == 1 && count[i] == 1) {
                count[i] = 0;
                ans[index] = i;
                if (solve(index + 1, n, ans, count)) return true;
                count[i] = 1;
                ans[index] = 0;
                continue;
            }
            if (count[i] != 0 && index + i < ans.length && ans[index + i] == 0) {
                count[i] = 0;
                ans[index] = i;
                ans[index + i] = i;
                if (solve(index + 1, n, ans, count)) return true;
                count[i] = 2;
                ans[index] = 0;
                ans[index + i] = 0;
            }
        }

        return false;
    }
}
