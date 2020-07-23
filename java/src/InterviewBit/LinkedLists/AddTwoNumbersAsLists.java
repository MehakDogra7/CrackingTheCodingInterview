package InterviewBit.LinkedLists;

public class AddTwoNumbersAsLists {

    public static void main(String[] args) {

        ListNode a = new ListNode(9);
        ListNode b = new ListNode(9);
        ListNode c = new ListNode(9);

        a.next = b;
        b.next = c;

        ListNode x = new ListNode(9);
        ListNode y = new ListNode(6);
        ListNode z = new ListNode(4);

        //x.next = y;
        //y.next = z;

        ListNode result = new AddTwoNumbersAsLists().solve(a, x);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    private ListNode solve(ListNode A, ListNode B) {

        int carry = 0;
        ListNode prev = new ListNode(Integer.MAX_VALUE);
        ListNode start = prev;
        ListNode res;
        while (A != null || B != null) {
            int temp = (A != null ? A.val : 0) + (B != null ? B.val : 0) + carry;
            res = new ListNode(temp % 10);
            if (temp >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            prev.next = res;
            prev = res;
            A = A != null ? A.next : null;
            B = B != null ? B.next : null;
        }

        if (carry == 1) {
            prev.next = new ListNode(carry);
        }
        return start.next;
    }
}
