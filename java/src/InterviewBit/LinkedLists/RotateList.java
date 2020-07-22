package InterviewBit.LinkedLists;

public class RotateList {

    public static void main(String[] args) {

        ListNode a = new ListNode(91);
        ListNode b = new ListNode(34);
        ListNode c = new ListNode(18);
        ListNode d = new ListNode(83);
        ListNode e = new ListNode(38);
        ListNode f = new ListNode(82);
        ListNode g = new ListNode(21);
        ListNode h = new ListNode(69);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;

        ListNode temp = new RotateList().rotateRight(a, 89);

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public ListNode rotateRight(ListNode A, int B) {
        if (A == null || A.next == null) {
            return A;
        }

        ListNode start = A;
        ListNode prev = null;

        ListNode temp = A;
        int size = 1;
        while (temp.next != null) {
            temp = temp.next;
            size++;
        }

        B = B % size;

        if (B == 0)
            return A;

        B = size - B;
        while (B > 0) {
            prev = start;
            start = start.next;
            B--;
        }

        prev.next = null;
        temp.next = A;

        return start;
    }
}
