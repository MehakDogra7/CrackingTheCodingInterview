package Question450.BinarySearchTree;

public class ReplaceEveryElementWithLeastGreaterOnItsRightSide {

    TreeNode root;

    public static void main(String[] args) {
        int[] A = {8, 58, 71, 18, 31, 32, 63, 92,
                43, 3, 91, 93, 25, 80, 28};

        int[] res = new ReplaceEveryElementWithLeastGreaterOnItsRightSide().solve(A);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }

    private int[] solve(int[] A) {

        int n = A.length;
        int[] res = new int[n];
        res[n - 1] = -1;
        root = new TreeNode(A[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            root = insertIntoTree(root, A[i], res, i, Integer.MAX_VALUE);
        }

        return res;
    }

    private TreeNode insertIntoTree(TreeNode curr, int element, int[] res, int i, int resultedValue) {
        if (curr == null) {
            res[i] = resultedValue == Integer.MAX_VALUE ? -1 : resultedValue;
            return new TreeNode(element);
        }

        if (element > curr.val) {
            curr.right = insertIntoTree(curr.right, element, res, i, resultedValue);
        } else {
            curr.left = insertIntoTree(curr.left, element, res, i, Math.min(curr.val, resultedValue));
        }

        curr.height = 1 + Math.max(height(curr.left), height(curr.right));
        int balancingFactor = height(curr.left) - height(curr.right);

        if (balancingFactor > 1) {
            if (element < curr.left.val)
                return handleLeftLeftCase(curr);
            else
                return handleLeftRightCase(curr);
        } else if (balancingFactor < -1) {
            if (element > curr.right.val)
                return handleRightRightCase(curr);
            else
                return handleRightLeftCase(curr);
        }
        return curr;
    }

    /**
     * TC: O(1)
     * SC: O(1)
     */
    private TreeNode handleRightLeftCase(TreeNode currNode) {
        TreeNode y = currNode.right;
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        currNode.right = x;
        return handleRightRightCase(currNode);
    }

    /**
     * TC: O(1)
     * SC: O(1)
     */
    private TreeNode handleRightRightCase(TreeNode currNode) {
        TreeNode y = currNode.right;
        TreeNode T2 = y.left;

        // Perform rotation
        y.left = currNode;
        currNode.right = T2;

        //  Update heights
        currNode.height = Math.max(height(currNode.left), height(currNode.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    /**
     * TC: O(1)
     * SC: O(1)
     */
    private TreeNode handleLeftRightCase(TreeNode currNode) {
        TreeNode x = currNode.left;
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        currNode.left = y;
        return handleLeftLeftCase(currNode);
    }

    /**
     * TC: O(1)
     * SC: O(1)
     */
    private TreeNode handleLeftLeftCase(TreeNode currNode) {
        TreeNode x = currNode.left;
        TreeNode T2 = x.right;

        // Perform rotation
        x.right = currNode;
        currNode.left = T2;

        // Update heights
        currNode.height = Math.max(height(currNode.left), height(currNode.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        return node.height;
    }

    static class TreeNode {
        int val, height;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            height = 1;
        }
    }
}
