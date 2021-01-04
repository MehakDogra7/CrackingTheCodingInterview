package Question450.LinkedList;

public class Add2NumbersRepresentedByLinkedList {

    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(5);

        a.next = b;
        b.next = c;

        Node x = new Node(4);
        Node y = new Node(5);

        x.next = y;

        Node temp = addLists(a, x);
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    static Node addLists(Node first, Node second) {
        // code here
        // return head of sum list
        first = reverse(first);
        second = reverse(second);

        Node result = new Node(Integer.MAX_VALUE), temp = result.next, prev = result;
        boolean carry = false;

        while (first != null || second != null) {
            temp = new Node(Integer.MAX_VALUE);
            int curr = (first == null ? 0 : first.data) + (second == null ? 0 : second.data);
            if (carry) curr++;

            if (curr < 10) {
                temp.data = curr;
                carry = false;
            } else {
                temp.data = curr - 10;
                carry = true;
            }

            prev.next = temp;
            prev = temp;
            first = first == null ? null : first.next;
            second = second == null ? null : second.next;
        }

        if (carry) {
            temp = new Node(1);
            prev.next = temp;
        }
        return reverse(result.next);
    }

    public static Node reverse(Node node) {
        Node curr = node, prev = null, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
