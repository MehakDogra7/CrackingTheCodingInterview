package Question450.LinkedList;

public class InteresectionOf2SortedList {

    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(5);

        a.next = b;
        b.next = c;

        Node x = new Node(4);
        Node y = new Node(5);

        x.next = y;

        Node temp = findIntersection(a, x);
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static Node findIntersection(Node head1, Node head2) {
        // code here.
        Node ptr1 = head1, ptr2 = head2;
        Node prev = new Node(Integer.MAX_VALUE), start = prev;

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.data == ptr2.data) {
                prev.next = new Node(ptr1.data);
                prev = prev.next;
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            } else if (ptr1.data < ptr2.data) ptr1 = ptr1.next;
            else ptr2 = ptr2.next;
        }
        return start.next;
    }
}
