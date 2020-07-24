package InterviewBit.LinkedLists;

public class KthNodeFromMiddle {

    public static void main(String[] args) {

        ListNode a = new ListNode(3);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(7);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(6);
        ListNode f = new ListNode(16);
        ListNode g = new ListNode(15);
        ListNode h = new ListNode(61);
        ListNode i = new ListNode(16);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;

        System.out.println(new KthNodeFromMiddle().solve(a, 3));
    }

    private int solve(ListNode A, int B) {
        int size = 0;
        ListNode temp = A;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        int mid = (size / 2) + 1;
        if (B >= mid)
            return -1;

        int required = mid - B;
        temp = A;
        while (required > 1) {
            temp = temp.next;
            required--;
        }

        return temp.val;
    }


}
