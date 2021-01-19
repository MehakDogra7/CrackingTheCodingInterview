package Question450.StacksAndQueues;

import java.util.Stack;

public class TheCelebrityProblem {

    public static void main(String[] args) {
        int[][] M = {
                {0, 1, 0},
                {0, 0, 0},
                {0, 1, 0}
        };
        System.out.println(new TheCelebrityProblem().celebrity(M, M.length));
    }

    /**
     * TC: O(n)
     * SC: O(1)
     *
     * @param M
     * @param n
     * @return
     */
    int celebrity(int[][] M, int n) {
        int A = 0, B = n - 1;

        while (A < B) {
            if (knows(A, B, M)) A++;
            else B--;
        }
        int celebrity = A;

        for (int i = 0; i < n; i++) {
            if (i != celebrity) {
                if (!knows(i, celebrity, M) || knows(celebrity, i, M)) return -1;
            }
        }
        return celebrity;
    }

    /**
     * TC: O(n)
     * SC: O(n)
     *
     * @param M
     * @param n
     * @return
     */
    int celebrityUsingStack(int[][] M, int n) {
        // code here
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++)
            stack.push(i);

        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (knows(a, b, M)) stack.push(b);
            else stack.push(a);
        }

        int celebrity = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i != celebrity) {
                if (!knows(i, celebrity, M) || knows(celebrity, i, M)) return -1;
            }
        }

        return celebrity;
    }

    private boolean knows(int a, int b, int[][] M) {
        return M[a][b] == 1;
    }
}
