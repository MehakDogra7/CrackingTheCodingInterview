package Question450.LinkedList;

public class SortAKSortedDoublyLinkedList {

    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(6);
        Node c = new Node(2);
        Node d = new Node(12);
        Node e = new Node(56);
        Node f = new Node(8);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        b.prev = a;
        c.prev = b;
        d.prev = c;
        e.prev = d;
        f.prev = e;

        Node head = solve(a, 2);

        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    private static Node solve(Node head, int k) {
        if (head == null || head.next == null) return head;

        Node curr = head;
        head = null;
        while (curr != null) {
            Node correct = curr, temp = curr;
            for (int i = 0; temp != null && i <= k; i++) {
                if (temp.data < correct.data) correct = temp;
                temp = temp.next;
            }
            boolean isSwapped = swap(curr, correct);
            curr = isSwapped ? correct.next : curr.next;
            head = head == null ? (isSwapped ? correct : curr) : head;
        }
        return head;
    }

    private static boolean swap(Node x, Node y) {
        if (x == y) return false;

        Node xPrev = x.prev, yPrev = y.prev;
        Node xNext = x.next, yNext = y.next;

        if (xPrev != null) {
            xPrev.next = y;
            y.prev = xPrev;
        } else {
            y.prev = null;
        }

        if (xNext != null) {
            if (xNext != y) {
                xNext.prev = y;
                y.next = xNext;
            } else {
                y.next = x;
            }
        } else {
            y.next = null;
        }

        if (yPrev != null) {
            if (yPrev != x) {
                yPrev.next = x;
                x.prev = yPrev;
            } else {
                x.prev = y;
            }
        } else {
            x.prev = null;
        }

        if (yNext != null) {
            yNext.prev = x;
            x.next = yNext;
        } else {
            x.next = null;
        }
        return true;
    }

    static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }
}
