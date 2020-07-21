package InterviewBit.LinkedLists;

public class RemoveDupesFromSortedList2 {

    public static void main(String[] args) {
        new RemoveDupesFromSortedList2().main();
    }

    private void main() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
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
        if (A.val == A.next.val) {
            int prev = A.val;
            while ((A != null && ((A.val == prev) || A.next != null && A.val == A.next.val))) {
                prev = A.val;
                A = A.next;
            }
        }

        ListNode curr = A;

        while (curr != null) {
            ListNode temp = curr.next;
            boolean flag = false;
            while (temp != null && temp.next != null) {
                if (temp.val == temp.next.val) {
                    temp = temp.next;
                    flag = true;
                } else {
                    break;
                }
            }
            if (flag) {
                curr.next = temp.next;
            } else {
                curr.next = temp;
                curr = curr.next;
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
