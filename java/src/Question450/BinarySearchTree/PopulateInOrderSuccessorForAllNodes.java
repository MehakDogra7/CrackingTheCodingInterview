package Question450.BinarySearchTree;

public class PopulateInOrderSuccessorForAllNodes {

    static Node prev = null;

    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(8);
        Node c = new Node(12);
        Node d = new Node(3);

        a.left = b;
        a.right = c;
        b.left = d;

        populateNext(a);
        printInOrder(a);
    }

    public static void populateNext(Node root) {
        //Add your code here.
        if (root == null) return;
        prev = null;
        inOrder(root);
    }

    private static void inOrder(Node curr) {
        if (curr == null) return;

        inOrder(curr.right);
        curr.next = prev;
        prev = curr;
        inOrder(curr.left);
    }

    private static void printInOrder(Node curr) {
        if (curr == null) return;

        printInOrder(curr.left);
        System.out.println(curr.data + " " + (curr.next == null ? -1 : curr.next.data));
        printInOrder(curr.right);
    }

    private static class Node {
        int data;
        Node left, right, next;

        Node(int d) {
            data = d;
            left = right = next = null;
        }
    }
}
