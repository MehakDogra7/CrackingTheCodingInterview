package InterviewBit.LinkedLists;

public class RemoveNthNodeFromListEnd {

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

        ListNode temp = new RemoveNthNodeFromListEnd().remove(a, 5);

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    private ListNode remove(ListNode A, int B) {

        if (A == null) {
            return A;
        }

        ListNode temp = A;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        if (B >= size) {
            return A.next;
        }

        temp = A;
        int i = 0;
        while (i < (size - B) - 1) {
            i++;
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }

        return A;
    }
}
