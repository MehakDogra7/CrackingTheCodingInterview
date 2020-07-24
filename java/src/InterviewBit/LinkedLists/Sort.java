package InterviewBit.LinkedLists;

/**
 * Sort with Time Complexity of O(nlogn)
 */
public class Sort {

    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(6);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        ListNode temp = new Sort().sortList(a);

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public ListNode sortList(ListNode A) {
        if (A == null || A.next == null)
            return A;

        int size = 0;
        ListNode temp = A;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        int mid = size / 2;
        temp = A;
        while (mid > 1) {
            temp = temp.next;
            mid--;
        }

        ListNode part2 = sortList(temp.next);
        temp.next = null;
        ListNode part1 = sortList(A);

        return merge(part1, part2);
    }

    public ListNode merge(ListNode x, ListNode y) {
        if (x == null)
            return y;
        if (y == null)
            return x;

        ListNode start = new ListNode(Integer.MIN_VALUE);
        ListNode prev = start;

        while (x != null || y != null) {
            int xVal = x != null ? x.val : Integer.MAX_VALUE;
            int yVal = y != null ? y.val : Integer.MAX_VALUE;
            if (xVal <= yVal) {
                prev.next = x;
                x = x.next;
            } else {
                prev.next = y;
                y = y.next;
            }
            prev = prev.next;
        }

        return start.next;
    }
}
