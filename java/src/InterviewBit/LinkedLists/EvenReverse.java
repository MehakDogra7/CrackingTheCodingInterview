package InterviewBit.LinkedLists;

public class EvenReverse {

    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        ListNode node = new EvenReverse().solve(a);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode solve(ListNode A) {
        if (A == null || A.next == null || A.next.next == null)
            return A;

        ListNode odd = A;
        ListNode even = A.next;

        ListNode evenStart = even;

        ListNode temp = even.next;
        boolean isOdd = true;

        while (temp != null) {
            if (isOdd) {
                odd.next = temp;
                odd = odd.next;
            } else {
                even.next = temp;
                even = even.next;
            }
            isOdd = !isOdd;
            temp = temp.next;
        }
        odd.next = null;
        even.next = null;

        odd = A;
        even = reverse(evenStart);

        ListNode nextOdd = null;

        while (odd != null && even != null) {
            nextOdd = odd.next;
            odd.next = even;
            even = even.next;
            odd.next.next = nextOdd;
            odd = nextOdd;
        }

        return A;
    }

    public ListNode reverse(ListNode even) {
        if (even == null || even.next == null) {
            return even;
        }

        ListNode prev = null;
        ListNode curr = even;
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
