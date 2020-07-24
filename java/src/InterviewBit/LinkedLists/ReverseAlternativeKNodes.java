package InterviewBit.LinkedLists;

public class ReverseAlternativeKNodes {


    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(6);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(10);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        ListNode temp = new ReverseAlternativeKNodes().solve(a, 2);

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public ListNode solve(ListNode A, int B) {
        ListNode start = new ListNode(Integer.MAX_VALUE);
        start.next = A;
        ListNode prev = start;
        ListNode curr = A;
        boolean flag = true;

        while (curr != null) {
            if (flag)
                prev.next = reverseTillK(curr, B);
            for (int i = 0; i <= B && curr != null && !flag; i++) {
                prev = curr;
                curr = curr.next;
            }
            flag = !flag;
        }

        return start.next;
    }

    public ListNode reverseTillK(ListNode A, int B) {
        if (A == null || A.next == null)
            return A;

        ListNode first = A;
        ListNode curr = A;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null && B > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            B--;
        }

        first.next = curr;
        return prev;
    }


}
