package InterviewBit.LinkedLists;

public class Subtract {

    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode a1 = new ListNode(7);
        ListNode b1 = new ListNode(8);
        ListNode c1 = new ListNode(9);
        ListNode d1 = new ListNode(10);
        ListNode e1 = new ListNode(11);
        ListNode f1 = new ListNode(12);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = a1;
        /*a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        d1.next = e1;
        e1.next = f1;*/

        ListNode node = new Subtract().subtract(a);
        System.out.println();
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public ListNode subtract(ListNode A) {
        if (A == null || A.next == null) return A;

        ListNode temp = A;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        int x = 1;
        int mid = (int) Math.ceil(size / 2.0);
        temp = A;
        while (x < mid) {
            temp = temp.next;
            x++;
        }

        System.out.println(size + " " + temp.val);
        temp.next = reverse(temp.next);

        ListNode half = temp.next;
        ListNode start = A;
        while (half != null) {
            start.val = half.val - start.val;
            start = start.next;
            half = half.next;
        }

        temp.next = reverse(temp.next);

        return A;
    }

    private ListNode reverse(ListNode curr) {

        ListNode prev = null;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
