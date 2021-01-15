package Question450.BinarySearchTree;

import Question450.BinaryTrees.Node;

import java.util.ArrayList;

public class ConvertBTToBST {

    ArrayList<Integer> inOrder;
    int i;

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);

        a.left = b;
        a.right = c;
        b.left = d;

        Node head = new ConvertBTToBST().binaryTreeToBST(a);
        ConvertBTToBST convertBTToBST = new ConvertBTToBST();
        convertBTToBST.inOrder = new ArrayList<>();
        convertBTToBST.generateInOrder(head);
        convertBTToBST.inOrder.forEach(i -> System.out.print(i + " "));

    }

    public Node binaryTreeToBST(Node root) {
        // Your code here
        inOrder = new ArrayList<>();
        generateInOrder(root);
        inOrder.sort(Integer::compare);
        i = 0;
        populateUpdateValues(root);
        return root;
    }

    private void populateUpdateValues(Node curr) {
        if (curr == null) return;
        populateUpdateValues(curr.left);
        curr.data = inOrder.get(i++);
        populateUpdateValues(curr.right);
    }

    private void generateInOrder(Node curr) {
        if (curr == null) return;
        generateInOrder(curr.left);
        inOrder.add(curr.data);
        generateInOrder(curr.right);
    }
}
