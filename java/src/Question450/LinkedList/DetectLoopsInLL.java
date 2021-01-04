package Question450.LinkedList;

public class DetectLoopsInLL {

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = d;

        System.out.println(detectLoop(a));
    }

    public static boolean detectLoop(Node head) {
        // Add code here
        if (head == null || head.next == null) return false;

        Node slow = head.next, fast = head.next.next;

        while (fast != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
        }
        return false;
    }
}
