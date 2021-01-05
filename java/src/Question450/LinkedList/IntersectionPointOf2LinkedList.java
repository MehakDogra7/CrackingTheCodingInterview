package Question450.LinkedList;

public class IntersectionPointOf2LinkedList {

    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(5);

        a.next = b;
        b.next = c;

        Node x = new Node(1);

        x.next = c;

        System.out.println(new IntersectionPointOf2LinkedList().intersectPoint(a, x));
    }

    public int intersectPoint(Node head1, Node head2) {
        // code here
        int size1 = 0, size2 = 0;
        Node ptr1 = head1, ptr2 = head2;
        while (ptr1 != null || ptr2 != null) {
            if (ptr1 != null) size1++;
            if (ptr2 != null) size2++;
            ptr1 = ptr1 != null ? ptr1.next : null;
            ptr2 = ptr2 != null ? ptr2.next : null;
        }

        ptr1 = head1;
        ptr2 = head2;
        if (size1 > size2) {
            int diff = size1 - size2;
            while (diff-- > 0) {
                ptr1 = ptr1.next;
            }
        } else if (size1 < size2) {
            int diff = size2 - size1;
            while (diff-- > 0) {
                ptr2 = ptr2.next;
            }
        }
        while (ptr1 != null && ptr2 != null && ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1 == null || ptr2 == null ? -1 : ptr1.data;
    }
}
