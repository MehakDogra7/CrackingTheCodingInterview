package InterviewBit.LinkedLists;

public class PartitionList {

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

        ListNode temp = new PartitionList().partition(a, 6);

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public ListNode partition(ListNode A, int B) {
        if (A == null || A.next == null)
            return A;

        ListNode start = new ListNode(Integer.MAX_VALUE);
        start.next = A;

        ListNode last = A;
        int size = 1;
        while (last.next != null) {
            size++;
            last = last.next;
        }

        ListNode temp = start;
        while (size > 0) {
            if (temp.next.val >= B) {
                last.next = temp.next;
                temp.next = temp.next.next;
                last.next.next = null;
                last = last.next;
            } else {
                temp = temp.next;
            }
            size--;
        }

        return start.next;
    }
}
