package Question450.BinaryTrees;

public class SumOfNodesInLongestPathInBT {

    int maxLevel;
    int maxSum;

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        System.out.println(new SumOfNodesInLongestPathInBT().sumOfLongRootToLeafPath(a));
    }

    public int sumOfLongRootToLeafPath(Node root) {
        if (root == null) return 0;

        maxLevel = 0;
        maxSum = Integer.MIN_VALUE;
        preOrder(root, 0, 0);
        return maxSum;
    }

    private void preOrder(Node curr, int level, int sumTillNow) {
        if (curr == null) return;
        if (curr.left == null && curr.right == null) {
            if (level > maxLevel) {
                maxLevel = level;
                maxSum = sumTillNow + curr.data;
            } else if (level == maxLevel) {
                maxSum = Math.max(maxSum, sumTillNow + curr.data);
            }
            return;
        }
        preOrder(curr.left, level + 1, sumTillNow + curr.data);
        preOrder(curr.right, level + 1, sumTillNow + curr.data);
    }
}
