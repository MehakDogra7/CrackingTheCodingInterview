package Question450.BinarySearchTree;

import Question450.BinaryTrees.Node;

import java.util.ArrayList;

public class ConvertBSTTOBBST {

    ArrayList<Node> inOrder;

    public static void main(String[] args) {
        Node a = new Node(4);
        Node b = new Node(3);
        Node c = new Node(2);
        Node d = new Node(1);

        a.left = b;
        b.left = c;
        c.left = d;

        Node head = new ConvertBSTTOBBST().convertBSTTOBBST(a);

        System.out.println(head.data);
    }

    private Node convertBSTTOBBST(Node curr) {
        inOrder = new ArrayList<>();
        generateInOrder(curr);

        return generateTree(0, inOrder.size() - 1);
    }

    private Node generateTree(int start, int end) {
        if (end < start) return null;

        int mid = (start + end) / 2;
        Node curr = inOrder.get(mid);
        curr.left = generateTree(start, mid - 1);
        curr.right = generateTree(mid + 1, end);
        return curr;
    }

    private void generateInOrder(Node curr) {
        if (curr == null) return;
        generateInOrder(curr.left);
        inOrder.add(curr);
        generateInOrder(curr.right);
    }
}
