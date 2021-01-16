package Question450.BinarySearchTree;

import Question450.BinaryTrees.Node;

import java.util.Stack;

public class CountPairSumIn2BSTs {

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(3);
        Node c = new Node(7);
        Node d = new Node(2);
        Node e = new Node(4);
        Node f = new Node(6);
        Node g = new Node(8);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        Node a1 = new Node(10);
        Node b1 = new Node(6);
        Node c1 = new Node(15);
        Node d1 = new Node(3);
        Node e1 = new Node(8);
        Node f1 = new Node(11);
        Node g1 = new Node(18);

        a1.left = b1;
        a1.right = c1;
        b1.left = d1;
        b1.right = e1;
        c1.left = f1;
        c1.right = g1;

        System.out.println(countPairs(a, a1, 16));
    }

    public static int countPairs(Node root1, Node root2, int x) {
        // your code here
        Stack<Node> inOrder = new Stack<>();
        Stack<Node> reverseInOrder = new Stack<>();
        int val1 = -1, val2 = -1, count = 0;
        boolean done1 = false, done2 = false;
        boolean finalDone1 = false, finalDone2 = false;

        Node curr1 = root1, curr2 = root2;
        while (!finalDone1 && !finalDone2) {
            while (!done1) {
                if (curr1 != null) {
                    inOrder.push(curr1);
                    curr1 = curr1.left;
                } else {
                    if (!inOrder.isEmpty()) {
                        Node pop = inOrder.pop();
                        val1 = pop.data;
                        curr1 = pop.right;
                    } else finalDone1 = true;
                    done1 = true;
                }
            }

            while (!done2) {
                if (curr2 != null) {
                    reverseInOrder.push(curr2);
                    curr2 = curr2.right;
                } else {
                    if (!reverseInOrder.isEmpty()) {
                        Node pop = reverseInOrder.pop();
                        val2 = pop.data;
                        curr2 = pop.left;
                    } else finalDone2 = true;
                    done2 = true;
                }
            }

            if (val1 + val2 == x) {
                count++;
                done2 = false;
                done1 = false;
            } else if (val1 + val2 > x) {
                done2 = false;
            } else {
                done1 = false;
            }
        }

        return count;
    }
}
