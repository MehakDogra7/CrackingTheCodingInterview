package Question450.BinarySearchTree;

import Question450.BinaryTrees.Node;

public class CountBSTNodesThatLieInGivenRange {

    int ans;

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(3);
        Node c = new Node(7);
        Node d = new Node(2);
        Node e = new Node(4);
        Node f = new Node(6);
        Node g = new Node(8);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        System.out.println(new CountBSTNodesThatLieInGivenRange().getCount(a, 4, 8));
    }

    int getCount(Node root, int l, int h) {
        //Your code here
        if (root == null) return 0;
        ans = 0;
        preOrder(root, l, h);
        return ans;
    }

    private void preOrder(Node curr, int l, int h) {
        if (curr == null) return;
        if (curr.data >= l && curr.data <= h) ans++;
        preOrder(curr.left, l, h);
        preOrder(curr.right, l, h);
    }
}
