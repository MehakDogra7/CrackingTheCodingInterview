package Question450.LinkedList;

public class DeleteNodesHavingGreaterValueOnRight {

    public static void main(String[] args) {
        Node a = new Node(12);
        Node b = new Node(15);
        Node c = new Node(10);
        Node d = new Node(11);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(2);
        Node h = new Node(3);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;

        Node temp = new DeleteNodesHavingGreaterValueOnRight().compute(a);
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public Node compute(Node head) {
        // your code here
        head = reverse(head);
        Node curr = head;

        while (curr != null && curr.next != null) {
            if (curr.next.data < curr.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return reverse(head);
    }

    public Node reverse(Node curr) {
        Node prev = null, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
