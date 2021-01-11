package Question450.BinaryTrees;

public class ConvertBinaryTreeToDoublyLinkedList {

    Node head = null;
    Node prev = null;

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

        Node head = new ConvertBinaryTreeToDoublyLinkedList().bToDLL(a);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.right;
        }
    }

    Node bToDLL(Node a) {
        if (a == null) return null;
        if (a.left == null && head == null) head = a;

        bToDLL(a.left);
        a.left = prev;
        if (prev != null) prev.right = a;
        prev = a;
        bToDLL(a.right);

        return head;
    }
}
