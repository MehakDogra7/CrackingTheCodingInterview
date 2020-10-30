package CollegeAssignments.Algo;

import java.util.Scanner;

public class DataStructure {

    static Node root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of queries that you want to execute: ");
        int Q = sc.nextInt();
        while (Q > 0) {
            solve(sc.nextInt(), sc.nextInt());
            Q--;
        }
    }


    private static void solve(int type, int value) {
        if (root == null) {
            if (type == 2)
                System.out.println("no");
            else if (type == 1)
                root = new Node(value);
            else
                System.out.println("Invalid Query");
        } else {
            if (type == 2)
                search(root, value, 0);
            else if (type == 1)
                insert(root, value);
            else
                System.out.println("Invalid Query");
        }
    }

    /**
     * TC: O(logn)
     * SC: O(logn)
     */
    private static void search(Node currNode, int value, int countTillNow) {
        if (currNode == null) {
            System.out.println("no");
        } else if (currNode.key == value) {
            System.out.println(countTillNow + currNode.NumberOfNodesLessThanCurrInCurrSubtree + 1);
        } else {
            if (value < currNode.key) {
                search(currNode.left, value, countTillNow);
            } else {
                search(currNode.right, value, countTillNow + currNode.NumberOfNodesLessThanCurrInCurrSubtree);
            }
        }
    }

    /**
     * TC: O(logn)
     * SC: O(logn)
     */
    private static Node insert(Node currNode, int value) {
        if (currNode == null) {
            return new Node(value);
        }
        if (value < currNode.key) {
            currNode.NumberOfNodesLessThanCurrInCurrSubtree++;
            currNode.left = insert(currNode.left, value);
        } else if (value > currNode.key) {
            currNode.right = insert(currNode.right, value);
        }

        currNode.height = 1 + Math.max(height(currNode.left), height(currNode.right));

        int balancingFactor = height(currNode.left) - height(currNode.right);

        if (balancingFactor > 1) {
            if (value < currNode.left.key)       //left left case
                return handleLeftLeftCase(currNode);
            else
                return handleLeftRightCase(currNode);  //Left Right Case
        } else if (balancingFactor < -1) {
            if (value > currNode.right.key)
                return handleRightRightCase(currNode);  //right right case
            else
                return handleRightLeftCase(currNode);   //right left case
        }

        return currNode;
    }

    /**
     * TC: O(1)
     * SC: O(1)
     */
    private static Node handleRightLeftCase(Node currNode) {
        Node y = currNode.right;
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        currNode.right = x;
        return handleRightRightCase(currNode);
    }

    /**
     * TC: O(1)
     * SC: O(1)
     */
    private static Node handleRightRightCase(Node currNode) {
        Node y = currNode.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = currNode;
        currNode.right = T2;

        //  Update heights
        currNode.height = Math.max(height(currNode.left), height(currNode.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    /**
     * TC: O(1)
     * SC: O(1)
     */
    private static Node handleLeftRightCase(Node currNode) {
        Node x = currNode.left;
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        currNode.left = y;
        return handleLeftLeftCase(currNode);
    }

    /**
     * TC: O(1)
     * SC: O(1)
     */
    private static Node handleLeftLeftCase(Node currNode) {
        Node x = currNode.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = currNode;
        currNode.left = T2;

        // Update heights
        currNode.height = Math.max(height(currNode.left), height(currNode.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    /**
     * TC: O(1)
     * SC: O(1)
     */
    private static int height(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    static class Node {
        int key, NumberOfNodesLessThanCurrInCurrSubtree, height;
        Node left, right;

        public Node(int key) {
            this.key = key;
            height = 1;
        }
    }
}
