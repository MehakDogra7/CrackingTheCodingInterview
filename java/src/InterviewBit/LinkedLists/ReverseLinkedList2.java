package InterviewBit.LinkedLists;

public class ReverseLinkedList2 {

    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode temp = new ReverseLinkedList2().solve(a, 2, 4);

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    /**
     * Solve it in 1 pass and with Constant space complexity
     * @param A
     * @param B
     * @param C
     * @return
     */
    private ListNode solve(ListNode A, int B, int C) {
        if (A == null || A.next == null)
            return A;

        ListNode result = new ListNode(Integer.MAX_VALUE);
        result.next = A;

        int x = 1;
        ListNode start = A;
        ListNode prev = result;
        while (start != null && x < B) {
            prev = start;
            start = start.next;
            x++;
        }

        ListNode old = prev;
        ListNode curr = start;
        ListNode next = null;

        while (curr != null && x <= C) {
            next = curr.next;
            curr.next = old;
            old = curr;
            curr = next;
            x++;
        }

        prev.next.next = curr;
        prev.next = old;

        return result.next;
    }
}
