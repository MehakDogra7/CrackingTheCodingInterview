package Question450.LinkedList;

public class TripletSumInSortedDoublyLinkedList {

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


        solve(a, 17);
    }

    private static void solve(Node head, int target) {
        Node tail = head;
        while (tail.next != null) tail = tail.next;

        Node curr = head;

        while (curr != null && curr.next != null && curr.next.next != null) {

            Node ptr1 = curr.next, ptr2 = tail;
            int required = target - curr.data;
            while (ptr1 != null && ptr2 != null &&
                    ptr2.next != ptr1 && ptr1 != ptr2) {

                if (ptr1.data + ptr2.data == required) {
                    System.out.println(ptr1.data + " " + ptr2.data + " " + curr.data);
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.prev;
                } else if (ptr1.data + ptr2.data < required) ptr1 = ptr1.next;
                else ptr2 = ptr2.prev;
            }
            curr = curr.next;
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
