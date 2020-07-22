package InterviewBit.LinkedLists;

public class SwapListNodesInPairs {

    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        //ListNode f = new ListNode(6);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        //e.next = f;

        ListNode temp = new SwapListNodesInPairs().swapPairs(a);

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public ListNode swapPairs(ListNode A) {

        if (A == null || A.next == null)
            return A;

        int B = 2;
        ListNode curr = A;
        ListNode prev = new ListNode(Integer.MAX_VALUE);
        ListNode result = prev;
        ListNode temp;

        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            temp = curr.next.next;
            curr.next.next = curr;

            prev = curr;
            prev.next = temp;
            curr = temp;
        }

        return result.next;
    }
}
