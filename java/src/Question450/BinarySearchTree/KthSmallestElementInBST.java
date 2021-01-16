package Question450.BinarySearchTree;

import Question450.BinaryTrees.Node;

public class KthSmallestElementInBST {

    int k, ans;

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(3);
        Node c = new Node(6);
        Node d = new Node(2);
        Node e = new Node(4);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        System.out.println(new KthSmallestElementInBST().KthSmallestElement(a, 3));
    }

    public int KthSmallestElement(Node root, int K) {
        //Your code here
        k = K;
        ans = -1;
        inOrder(root);
        return ans;
    }

    private void inOrder(Node curr) {
        if (curr == null || ans != -1) return;
        inOrder(curr.left);
        k--;
        if (k == 0) ans = curr.data;
        inOrder(curr.right);
    }
}
