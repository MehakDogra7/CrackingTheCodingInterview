package Question450.LinkedList;

public class DeleteLoopInLinkedList {

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = a;

        deleteLoop(a);

        Node temp = a;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void deleteLoop(Node head) {
        // Add code here
        if (head == null || head.next == null) return;

        Node slow = head.next, fast = head.next.next;

        while (fast != null) {
            if (slow == fast) break;
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
        }
        if (fast == null) return;

        if (fast == head) {
            Node temp = head;
            while (temp.next != head) temp = temp.next;

            temp.next = null;
            return;
        }

        slow = head;
        Node temp = fast;
        while (slow != fast) {
            temp = fast;
            slow = slow.next;
            fast = fast.next;
        }
        temp.next = null;
    }
}
