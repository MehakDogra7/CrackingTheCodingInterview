package Question450.LinkedList;

public class Add1ToLinkedList {

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);

        a.next = b;
        b.next = c;
        c.next = d;

        Node temp = addOne(a);
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static Node addOne(Node head) {
        //code here.
        boolean isNewNodeNeeded = addOneToNode(head);
        if (isNewNodeNeeded) {
            Node temp = new Node(1);
            temp.next = head;
            head = temp;
        }
        return head;
    }

    private static boolean addOneToNode(Node curr) {
        if (curr.next == null) {
            if (curr.data < 9) {
                curr.data++;
                return false;
            } else {
                curr.data = 0;
                return true;
            }
        } else {
            boolean carry = addOneToNode(curr.next);
            if (carry) {
                if (curr.data < 9) {
                    curr.data++;
                    return false;
                } else {
                    curr.data = 0;
                    return true;
                }
            }
        }
        return false;
    }
}
