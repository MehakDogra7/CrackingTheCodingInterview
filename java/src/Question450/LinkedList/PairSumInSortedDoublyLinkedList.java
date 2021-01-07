package Question450.LinkedList;

public class PairSumInSortedDoublyLinkedList {

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        Node f = new Node(8);
        Node g = new Node(9);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        b.prev = a;
        c.prev = b;
        d.prev = c;
        e.prev = d;
        f.prev = e;
        g.prev = f;


        solve(a, 7);
    }

    private static void solve(Node head, int target) {
        Node tail = head;
        while (tail.next != null) tail = tail.next;

        while (head != null && tail != null &&
                tail.next != head && head != tail) {

            if (head.data + tail.data == target) {
                System.out.println(head.data + " " + tail.data);
                head = head.next;
                tail = tail.prev;
            } else if (head.data + tail.data < target) head = head.next;
            else tail = tail.prev;
        }
    }

    static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }
}
