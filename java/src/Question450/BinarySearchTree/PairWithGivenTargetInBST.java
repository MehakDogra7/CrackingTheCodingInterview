package Question450.BinarySearchTree;

import Question450.BinaryTrees.Node;

import java.util.Stack;

public class PairWithGivenTargetInBST {

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(3);
        Node c = new Node(6);
        Node d = new Node(2);
        Node e = new Node(4);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        System.out.println(new PairWithGivenTargetInBST().isPairPresent(a, 8));
    }

    public int isPairPresent(Node root, int target) {
        // Write your code here
        Stack<Node> inOrder = new Stack<>();
        Stack<Node> reverseInOrder = new Stack<>();
        int val1 = -1, val2 = -1;
        boolean done1 = false, done2 = false;
        Node curr1 = root, curr2 = root;
        while (true) {
            while (!done1) {
                if (curr1 != null) {
                    inOrder.push(curr1);
                    curr1 = curr1.left;
                } else {
                    if (!inOrder.isEmpty()) {
                        Node pop = inOrder.pop();
                        val1 = pop.data;
                        curr1 = pop.right;
                    }
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
                    }
                    done2 = true;
                }
            }

            if (val1 != val2 && (val1 + val2 == target)) {
                return 1;
            } else if (val1 + val2 > target) {
                done2 = false;
            } else {
                done1 = false;
            }
            if (val1 >= val2) return 0;
        }
    }
}
