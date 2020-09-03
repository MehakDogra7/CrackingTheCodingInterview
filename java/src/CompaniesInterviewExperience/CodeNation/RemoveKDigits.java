package CompaniesInterviewExperience.CodeNation;

import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-k-digits/
 * https://www.geeksforgeeks.org/codenation-interview-experience-on-campus-for-internship-2/
 */
public class RemoveKDigits {

    public static void main(String[] args) {
        System.out.println(new RemoveKDigits().removeKdigits("1432219", 3));
    }

    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        if (k == 0) return num;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (i = 0; i < num.length() && k > 0; i++) {
            if (stack.isEmpty() || stack.peek() <= num.charAt(i) - 48) {
                stack.push(num.charAt(i) - 48);
            } else {
                while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i) - 48) {
                    stack.pop();
                    k--;
                }
                stack.push(num.charAt(i) - 48);
            }
        }
        StringBuilder res = new StringBuilder(num.substring(i));
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        i = 0;
        for (i = 0; i < res.length(); i++) {
            if (res.charAt(i) != '0') break;
        }
        if (i == res.length()) return "0";
        String result = res.substring(i);
        return result.substring(0, result.length() - k);
    }
}
