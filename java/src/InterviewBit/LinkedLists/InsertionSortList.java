package InterviewBit.LinkedLists;

public class InsertionSortList {

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

        ListNode temp = new InsertionSortList().insertionSortList(a);

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public ListNode insertionSortList(ListNode A) {

        if (A == null || A.next == null)
            return A;

        ListNode temp = A;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        temp = A.next;
        ListNode start = new ListNode(Integer.MIN_VALUE);
        start.next = A;

        for (int j = 1; j < size; j++) {
            ListNode key = temp;
            temp = temp.next;

            //Insert key node in the sorted sequence 0 to j-1
            int i = 0;
            ListNode sorted = start;
            while (i < j && sorted.next.val < key.val) {
                sorted = sorted.next;
                i++;
            }

            //move key from its current position to next to start
            shift(key, sorted);
        }

        return start.next;
    }

    private void shift(ListNode key, ListNode sorted) {
        ListNode oneBeforeKey = sorted;
        while (oneBeforeKey.next != key) {
            oneBeforeKey = oneBeforeKey.next;
        }

        oneBeforeKey.next = oneBeforeKey.next.next;
        key.next = sorted.next;
        sorted.next = key;
    }
}
