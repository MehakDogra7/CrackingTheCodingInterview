package Question450.LinkedList;

public class ReverseLLInGroupOfK {

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;

        Node temp = reverse(a, 4);

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static Node reverse(Node node, int k) {
        //Your code here
        if (node == null || node.next == null) return node;

        Node result = new Node(Integer.MAX_VALUE), prev = result, temp = node;
        result.next = node;

        while (prev != null) {
            Node start = temp;
            int i = 0;
            while (temp != null && i++ < k) {
                temp = temp.next;
            }
            prev.next = reverse2(start, k);
            prev = start;
        }

        return result.next;
    }

    /**
     * @param node
     * @param k
     * @return head and tail
     */
    public static Node reverse2(Node node, int k) {
        if (node == null || node.next == null) return node;

        Node prev = null, next = null, curr = node, tail = node;

        while (curr != null && k-- > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

class Node {
    int data;
    Node next;

    public Node() {
    }

    Node(int key) {
        data = key;
        next = null;
    }
}