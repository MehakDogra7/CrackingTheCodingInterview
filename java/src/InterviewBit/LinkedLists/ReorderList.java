package InterviewBit.LinkedLists;

public class ReorderList {

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
        ListNode temp = new ReorderList().reorderList(a);

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public ListNode reorderList(ListNode A) {
        if (A == null || A.next == A)
            return A;

        int size = 0;
        ListNode temp = A;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int i = 1;
        temp = A;
        while (i < size / 2) {
            temp = temp.next;
            i++;
        }
        temp.next = reverse(temp.next);

        ListNode curr = A;
        for (i = 0; i < (size / 2); i++) {
            ListNode nodeToPut = temp.next;
            temp.next = temp.next.next;
            nodeToPut.next = curr.next;
            curr.next = nodeToPut;
            curr = nodeToPut.next;
        }

        return A;
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
}
