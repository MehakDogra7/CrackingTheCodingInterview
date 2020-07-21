package InterviewBit.LinkedLists;

public class RemoveDupesFromSortedList {

    public static void main(String[] args) {
        new RemoveDupesFromSortedList().main();
    }

    private void main() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(3);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode listNode = deleteDuplicates(a);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode deleteDuplicates(ListNode A) {

        if (A == null || A.next == null) {
            return A;
        }

        ListNode temp = A;

        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return A;
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
