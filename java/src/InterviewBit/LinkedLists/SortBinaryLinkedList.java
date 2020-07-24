package InterviewBit.LinkedLists;

public class SortBinaryLinkedList {

    public static void main(String[] args) {

        ListNode a = new ListNode(0);
        ListNode b = new ListNode(0);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(0);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode node = new SortBinaryLinkedList().solve(a);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private ListNode solve(ListNode A) {
        if (A == null || A.next == null)
            return A;

        int zero = 0;
        ListNode temp = A;
        while (temp != null) {
            if (temp.val == 0)
                zero++;
            temp = temp.next;
        }

        temp = A;
        while (temp != null) {
            if (zero > 0) {
                temp.val = 0;
                zero--;
            } else
                temp.val = 1;
            temp = temp.next;
        }

        return A;
    }
}
