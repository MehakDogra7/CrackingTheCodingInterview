package InterviewBit.LinkedLists;

public class KReverseLinkedList {
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

        ListNode temp = new KReverseLinkedList().reverseList(a, 3);

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public ListNode reverseList(ListNode A, int B) {

        ListNode temp = A;
        ListNode prev = new ListNode(Integer.MAX_VALUE);
        ListNode result = prev;

        while (temp != null) {
            int i = 0;
            ListNode start = temp;
            while (i < B) {
                temp = temp.next;
                i++;
            }

            prev.next = reverse(start, B);
            prev = start;
        }

        return result.next;
    }

    public ListNode reverse(ListNode list, int B) {

        if (list == null || list.next == null)
            return list;

        ListNode prev = null;
        ListNode next = null;
        ListNode curr = list;

        while (curr != null && B > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            B--;
        }

        return prev;
    }
}
