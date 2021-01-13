package Question450.BinaryTrees;

public class KthAncestorOfANode {

    int K;
    Node ans;

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        g.right = h;

        System.out.println(new KthAncestorOfANode().solve(a, 8, 2));
    }

    private int solve(Node root, int node, int k) {

        K = k + 1;
        findAncestor(root, node);
        if (K > 0) return -1;
        return ans.data;
    }

    private boolean findAncestor(Node curr, int node) {
        if (curr == null) return false;

        if (curr.data == node ||
                findAncestor(curr.left, node) || findAncestor(curr.right, node)) {
            K--;
            if (K == 0) ans = curr;

            return true;
        }
        return false;
    }
}
