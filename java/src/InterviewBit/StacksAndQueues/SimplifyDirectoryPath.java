package InterviewBit.StacksAndQueues;

import java.util.Stack;

public class SimplifyDirectoryPath {

    public static void main(String[] args) {
        String A = "/home//foo/";
        System.out.println(new SimplifyDirectoryPath().solve(A));
    }

    private String solve(String A) {
        StringBuilder res = new StringBuilder();
        String[] split = A.split("/");
        Stack<String> stack = new Stack<>();

        for (int i = 1; i < split.length; i++) {
            String curr = split[i];
            if (curr.length() == 0 || ".".equals(curr)) continue;
            else if ("..".equals(curr)) {
                if (!stack.isEmpty()) stack.pop();
            } else stack.push(curr);
        }

        if (stack.isEmpty()) return "/";

        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
            res.insert(0, "/");
        }

        return res.toString();
    }
}
