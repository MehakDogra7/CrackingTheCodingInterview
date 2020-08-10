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

        //let's say total nodes = x, cycle nodes = m
        //Identify the size of cycle, so size = m
        int size = 1;
        ListNode loop = slow.next;
        while (loop != slow) {
            loop = loop.next;
            size++;
        }

        ListNode ptr1 = a;
        ListNode ptr2 = a;

        //Move pointer 2 till the size of cycle it will point to mth node from head
        while (size > 0) {
            ptr2 = ptr2.next;
            size--;
        }

        //move both at same speed they will meet at first node of cycle how ?
        //To meet at first node ptr1 should move x-m steps then it will point to first node of cycle
        //since they both are moving at same pace ptr2 will also move x-m steps, and it is already at mth position
        //so after x-m more steps it will be at ==> m + x - m = x position from head and we already know that x is
        //the total size of linked list that means ptr2 will reach at the end of LL which is nothing but the starting
        //point of cycle.
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

        //let's say non cycle nodes = m, cycle nodes = n, and first meeting point is at k distance from first node of cycle
        //since fast ptr is meeting at double speed than the slow pointer then it means fastDistance = 2 * slowDistance
        //both will cover at least m + k and some cycles of n let's say fast covers x number of rounds and slow covers
        //y number of rounds so eq. would be (m + k + n*x) = 2 * (m + k + n*y)
        //after simplifying it we'll get ==> (m + k) = n * (x - 2y) which shows that (m + k) is the multiple of n (cycle size)
        //So solution would be to start slow from head and keep fast at the meeting point itself move both with the same pace
        //to meet at first node of cycle slow will move m steps and since fast is already at k and is moving at same pace
        //it will also move m steps and will be at (k + m), since we have already proved that (k + m) is a multiple of
        //cycle size (n) fast will also reach at the first node of cycle after making m steps from kth position i.e. (k + m).
        slow = a;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
