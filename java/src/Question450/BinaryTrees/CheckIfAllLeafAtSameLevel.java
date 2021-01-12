package Question450.BinaryTrees;

public class CheckIfAllLeafAtSameLevel {

    Integer leafLevel = null;

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

        System.out.println(new CheckIfAllLeafAtSameLevel().check(a));
    }

    boolean check(Node root) {
        // Your code here
        if (root == null) return true;
        return checkLevel(root, 0);
    }

    private boolean checkLevel(Node curr, int level) {
        if (curr == null) return true;
        if (curr.left == null && curr.right == null) {
            if (leafLevel == null) {
                leafLevel = level;
                return true;
            }
            return level == leafLevel;
        }

        return checkLevel(curr.left, level + 1) && checkLevel(curr.right, level + 1);
    }
}
