package Question450.LinkedList;

/**
 * TC: O(nlogn)
 * SC: O(1)
 */
//TODO
public class MergeSortForLinkedListIterativeConstantSpace {

    Node tail = new Node();
    Node nextSubList = new Node();

    public static void main(String[] args) {
        Node a = new Node(2);
        Node b = new Node(1);
        Node c = new Node(4);
        Node d = new Node(3);

        a.next = b;
        b.next = c;
        c.next = d;

        Node temp = new MergeSortForLinkedListIterativeConstantSpace().sortList(a);
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public Node sortList(Node head) {
        if (head == null || head.next == null)
            return head;
        int n = getCount(head);
        Node start = head;
        Node dummyHead = new Node();
        for (int size = 1; size < n; size = size * 2) {
            tail = dummyHead;
            while (start != null) {
                if (start.next == null) {
                    tail.next = start;
                    break;
                }
                Node mid = split(start, size);
                merge(start, mid);
                start = nextSubList;
            }
            start = dummyHead.next;
        }
        return dummyHead.next;
    }

    Node split(Node start, int size) {
        Node midPrev = start;
        Node end = start.next;
        //use fast and slow approach to find middle and end of second linked list
        for (int index = 1; index < size && (midPrev.next != null || end.next != null); index++) {
            if (end.next != null) {
                end = (end.next.next != null) ? end.next.next : end.next;
            }
            if (midPrev.next != null) {
                midPrev = midPrev.next;
            }
        }
        Node mid = midPrev.next;
        midPrev.next = null;
        nextSubList = end.next;
        end.next = null;
        // return the start of second linked list
        return mid;
    }

    void merge(Node list1, Node list2) {
        Node dummyHead = new Node();
        Node newTail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                newTail.next = list1;
                list1 = list1.next;
                newTail = newTail.next;
            } else {
                newTail.next = list2;
                list2 = list2.next;
                newTail = newTail.next;
            }
        }
        newTail.next = (list1 != null) ? list1 : list2;
        // traverse till the end of merged list to get the newTail
        while (newTail.next != null) {
            newTail = newTail.next;
        }
        // link the old tail with the head of merged list
        tail.next = dummyHead.next;
        // update the old tail to the new tail of merged list
        tail = newTail;
    }

    int getCount(Node head) {
        int cnt = 0;
        Node ptr = head;
        while (ptr != null) {
            ptr = ptr.next;
            cnt++;
        }
        return cnt;
    }
}
