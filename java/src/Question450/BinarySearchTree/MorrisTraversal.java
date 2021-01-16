package Question450.BinarySearchTree;

import Question450.BinaryTrees.Node;

public class MorrisTraversal {

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

        new MorrisTraversal().inOrderTraversal(a);
    }

    private void inOrderTraversal(Node root) {
        Node current, pre;

        if (root == null)
            return;

        current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                /* Find the inorder
                    predecessor of current
                 */
                pre = current.left;
                while (pre.right != null
                        && pre.right != current)
                    pre = pre.right;

                /* Make current as right
                   child of its
                 * inorder predecessor */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }

                /* Revert the changes made
                   in the 'if' part
                   to restore the original
                   tree i.e., fix
                   the right child of predecessor*/
                else {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
                // End of if condition pre->right == NULL

            }

        }
    }
}
