package CollegeAssignments.Algo;

public class CheckAVL {

    int max = Integer.MIN_VALUE;
    Node result = null;

    public static void main(String[] args) {
        Node a = new Node(1);
    }

    int checkBBST(Node currNode) {
        if (currNode == null) return 0;

        int left = checkBBST(currNode.left);
        int right = checkBBST(currNode.right);

        if (left == Integer.MAX_VALUE || right == Integer.MAX_VALUE) return Integer.MAX_VALUE;

        int balance = height(currNode.left) - height(currNode.right);

        if (balance >= -1 && balance <= 1) {
            int curr = left + right + 1;
            if (curr > max) {
                max = curr;
                result = currNode;
            }
            return curr;
        }
        return Integer.MAX_VALUE;
    }

    private static int height(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    static class Node {
        int key, height;
        Node left, right;

        public Node(int key) {
            this.key = key;
        }
    }
}
