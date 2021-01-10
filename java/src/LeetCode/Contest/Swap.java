package LeetCode.Contest;

import InterviewBit.LinkedLists.ListNode;

public class Swap {

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

        ListNode temp = new Swap().swapNodes(a, 1);

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode beg = head, end = head, temp = head;
        int tempK = k - 1;
        while (tempK > 0) {
            beg = beg.next;
            tempK--;
        }

        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        tempK = size - k;
        while (tempK > 0) {
            end = end.next;
            tempK--;
        }

        ListNode begNext = beg.next, endNext = end.next;
        beg.next = null;
        end.next = null;

        ListNode start = new ListNode(Integer.MAX_VALUE), prev = start, curr = head;
        while (curr != null) {
            if (curr == beg) {
                prev.next = end;
                prev = end;
                curr = begNext;
            } else if (curr == end) {
                prev.next = beg;
                prev = beg;
                curr = endNext;
            } else {
                prev.next = curr;
                prev = curr;
                curr = curr.next;
            }
        }
        return start.next;
    }
}
