package Question450.LinkedList;

/**
 * TC: O(nlogn)
 * SC: O(logn) for recursion
 */
public class MergeSortForLinkedListRecursiveExtraSpace {

    public static void main(String[] args) {
        Node a = new Node(2);
        Node b = new Node(1);
        Node c = new Node(4);
        Node d = new Node(3);

        a.next = b;
        b.next = c;
        c.next = d;

        Node temp = mergeSort(a);
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static Node mergeSort(Node head) {
        // add your code here
        if (head == null || head.next == null) return head;

        Node middle = getMiddle(head);
        Node middleNext = middle.next;

        middle.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(middleNext);

        return merge(left, right);
    }

    private static Node merge(Node left, Node right) {

        Node result = new Node(Integer.MAX_VALUE), prev = result;

        while (left != null || right != null) {
            if (right == null || (left != null && left.data < right.data)) {
                prev.next = left;
                prev = left;
                left = left.next;
            } else {
                prev.next = right;
                prev = right;
                right = right.next;
            }
        }
        return result.next;
    }

    private static Node getMiddle(Node head) {
        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
