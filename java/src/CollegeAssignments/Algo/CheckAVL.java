package CollegeAssignments.Algo;

public class CheckAVL {

    static int max = Integer.MIN_VALUE;
    static Node result = null;

    public static void main(String[] args) {
        Node a = new Node(1);
    }

    public static int[] checkBBST(Node currNode) {
        int[] res = new int[2];                     //1st Element will contain the totalNumber of nodes in currSubTree
                                                    //and 2nd Element will contain the height of currNode
        if (currNode == null) {
            res[0] = res[1] = 0;
            return res;
        }

        int[] left = checkBBST(currNode.left);
        int[] right = checkBBST(currNode.right);

        int heightOfLeftSubtree = left[1], heightOfRightSubtree = right[1];
        int nodesInLeftSubtree = left[0], nodeInRightSubtree = right[0];

        if (nodesInLeftSubtree == Integer.MAX_VALUE || nodeInRightSubtree == Integer.MAX_VALUE) {
            res[0] = Integer.MAX_VALUE;
            res[1] = Integer.MAX_VALUE;
            return res;
        }

        int balance = heightOfLeftSubtree - heightOfRightSubtree;

        if (balance >= -1 && balance <= 1) {
            int curr = nodesInLeftSubtree + nodeInRightSubtree + 1;
            if (curr > max) {
                max = curr;
                result = currNode;
            }
            res[0] = curr;
            res[1] = 1 + Math.max(heightOfLeftSubtree, heightOfRightSubtree);
            return res;
        }
        res[0] = Integer.MAX_VALUE;
        res[1] = Integer.MAX_VALUE;
        return res;
    }

    static class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
        }
    }
}
