package InterviewBit.LinkedLists;

import java.util.HashSet;
import java.util.Set;

public class ListCycle {

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
        e.next = e;

        //System.out.println(new ListCycle().solveUsingExtraSpace(a).val);
        //System.out.println(new ListCycle().solveOptimal(a).val);
        //System.out.println(new ListCycle().solveOptimalImmutable(a).val);
        System.out.println(new ListCycle().solveOptimalImmutableBest(a).val);

    }

    private ListNode solveUsingExtraSpace(ListNode A) {
        if (A == null || A.next == null)
            return null;

        Set<ListNode> set = new HashSet<>();

        ListNode temp = A;
        while (temp != null) {
            if (set.contains(temp))
                return temp;
            set.add(temp);
            temp = temp.next;
        }

        return null;
    }

    private ListNode solveOptimal(ListNode a) {
        if (a == null || a.next == null)
            return null;

        ListNode temp = a;
        ListNode next;
        ListNode check = new ListNode(Integer.MAX_VALUE);

        while (temp != null) {
            if (temp.next == check)
                return temp;

            next = temp.next;
            temp.next = check;
            temp = next;
        }

        return null;
    }

    private ListNode solveOptimalImmutable(ListNode a) {
        if (a == null || a.next == null)
            return null;

        ListNode slow = a;
        ListNode fast = a.next;

        while (slow != null && fast != null) {
            if (slow == fast)
                break;
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : null;
        }

        if (slow == null || fast == null)
            return null;

        int size = 1;
        ListNode loop = slow.next;
        while (loop != slow) {
            loop = loop.next;
            size++;
        }

        ListNode ptr1 = a;
        ListNode ptr2 = a;

        while (size > 0) {
            ptr2 = ptr2.next;
            size--;
        }

        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }

    private ListNode solveOptimalImmutableBest(ListNode a) {
        if (a == null || a.next == null)
            return null;

        ListNode slow = a.next;
        ListNode fast = a.next.next;

        while (slow != null && fast != null) {
            if (slow == fast)
                break;
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : null;
        }

        if (slow == null || fast == null)
            return null;

        slow = a;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
