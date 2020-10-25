package InterviewBit.GraphDSAndAlgo;

public class LargestDistanceBetweenNodesOfATree {

    int maxResult = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] A = {-1, 0, 0, 0, 3};
        System.out.println(new LargestDistanceBetweenNodesOfATree().solve(A));
    }

    public int solve(int[] A) {
        int root = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == -1) root = i;
        }

        dfs(A, root);
        return maxResult;
    }

    private int dfs(int[] A, int currNode) {
        int currMax1 = 0;
        int currMax2 = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == currNode) {
                int temp = dfs(A, i) + 1;
                if (temp > currMax1) {
                    currMax2 = currMax1;
                    currMax1 = temp;
                } else if (temp > currMax2) {
                    currMax2 = temp;
                }
            }
        }
        maxResult = Math.max(maxResult, currMax1 + currMax2);
        return currMax1;
    }
}
