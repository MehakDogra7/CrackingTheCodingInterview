package InterviewBit.LinkedLists;

public class MergeTwoSortedLists {

    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(5);

        a.next = b;
        b.next = c;

        ListNode x = new ListNode(1);
        ListNode y = new ListNode(4);
        ListNode z = new ListNode(6);

        x.next = y;
        y.next = z;

        ListNode merge = new MergeTwoSortedLists().merge(a, x);
        while (merge != null) {
            System.out.println(merge.val);
            merge = merge.next;
        }
    }

    private ListNode mergeInplace(ListNode A, ListNode B) {
        if (A == null)
            return B;
        if (B == null)
            return A;

        ListNode prev = new ListNode(Integer.MAX_VALUE);
        ListNode start = prev;
        while (A != null && B != null) {
            if (A.val <= B.val) {
                prev.next = A;
                prev = A;
                A = A.next;
            } else {
                prev.next = B;
                prev = B;
                B = B.next;
            }
        }

        if (A == null) {
            prev.next = B;
        } else {
            prev.next = A;
        }

        return start.next;
    }

    public ListNode merge(ListNode A, ListNode B) {
        if (A == null)
            return B;
        if (B == null)
            return A;

        ListNode start = new ListNode(Integer.MIN_VALUE);
        ListNode prev = start;

        while (A != null || B != null) {
            int xVal = A != null ? A.val : Integer.MAX_VALUE;
            int yVal = B != null ? B.val : Integer.MAX_VALUE;
            if (xVal <= yVal) {
                prev.next = A;
                A = A.next;
            } else {
                prev.next = B;
                B = B.next;
            }
            prev = prev.next;
        }

        return start.next;
    }
}
