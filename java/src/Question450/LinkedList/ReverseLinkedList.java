package Question450.LinkedList;

import InterviewBit.LinkedLists.ListNode;

public class ReverseLinkedList {

    ListNode head = null;

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

        ListNode temp = new ReverseLinkedList().solveRecursive(null, a);

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    private ListNode solveIterative(ListNode A) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = A;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private ListNode solveRecursive(ListNode prev, ListNode curr) {
        if (curr.next == null) {
            curr.next = prev;
            return curr;
        }

        ListNode next = curr.next;
        curr.next = prev;
        return solveRecursive(curr, next);
    }
}
