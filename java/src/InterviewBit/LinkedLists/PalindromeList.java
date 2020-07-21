package InterviewBit.LinkedLists;

public class PalindromeList {


    public static void main(String[] args) {
        new PalindromeList().main();
    }

    public void main() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println(lPalin(a));

    }

    public int lPalin(ListNode A) {
        ListNode temp = A;
        ListNode halfNode = A;

        int size = 1;

        while (temp.next != null) {
            temp = temp.next;
            size++;
        }

        int half = size / 2;
        while (half > 0) {
            halfNode = halfNode.next;
            half--;
        }

        if ((size & 1) == 1) {
            halfNode = halfNode.next;
        }

        halfNode = reverse(halfNode);
        temp = A;

        while (temp != null && halfNode != null) {
            if (temp.val != halfNode.val) {
                return 0;
            }
            temp = temp.next;
            halfNode = halfNode.next;
        }

        return 1;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
