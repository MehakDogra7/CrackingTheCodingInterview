package Question450.BinaryTrees;

import java.util.Arrays;

public class ConstructTreeFromInOrderAndPreOrder {

    static int p;

    public static void main(String[] args) {
        int[] inorder = {1, 6, 8, 7};                       // left root right
        int[] preorder = {1, 6, 7, 8};                      // root left right

        Node root = buildTree(inorder, preorder, inorder.length);
    }

    public static Node buildTree(int inorder[], int preorder[], int n) {
        p = 0;
        return constructTree(inorder, preorder);
    }

    private static Node constructTree(int[] inorder, int[] preorder) {
        if (inorder.length == 0) return null;

        Node curr = new Node(preorder[p++]);
        int i = 0;
        for (i = 0; i < inorder.length; i++) if (inorder[i] == curr.data) break;

        curr.left = constructTree(Arrays.copyOfRange(inorder, 0, i), preorder);
        curr.right = constructTree(Arrays.copyOfRange(inorder, i + 1, inorder.length), preorder);
        return curr;
    }
}
