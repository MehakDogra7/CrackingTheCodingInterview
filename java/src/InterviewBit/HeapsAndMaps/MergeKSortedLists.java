package InterviewBit.HeapsAndMaps;

import InterviewBit.LinkedLists.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(10);
        ListNode c = new ListNode(20);

        a.next = b;
        b.next = c;

        ListNode x = new ListNode(4);
        ListNode y = new ListNode(11);
        ListNode z = new ListNode(13);

        x.next = y;
        y.next = z;

        ListNode m = new ListNode(3);
        ListNode n = new ListNode(8);
        ListNode o = new ListNode(9);

        m.next = n;
        n.next = o;

        ArrayList<ListNode> A = new ArrayList<>(List.of(a, x, m));
        ListNode listNode = new MergeKSortedLists().mergeKLists(A);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((x, y) -> {
            if (x.val == y.val) return 0;
            else if (x.val < y.val) return -1;
            return 1;
        });
        for (ListNode currList : a) {
            ListNode temp = currList;
            while (temp != null) {
                heap.add(temp);
                temp = temp.next;
            }
        }

        ListNode result = new ListNode(Integer.MAX_VALUE);
        ListNode prev = result;
        while (heap.size() > 0) {
            prev.next = heap.poll();
            prev = prev.next;
        }

        return result.next;
    }
}

