package InterviewBit.TreeDataStructure;

import java.util.ArrayList;
import java.util.List;

public class BTFromInAndPostorder {
    public static void main(String[] args) {
        ArrayList<Integer> inOrder = new ArrayList<>(List.of(5, 2, 1, 4, 3));
        ArrayList<Integer> postOrder = new ArrayList<>(List.of(5, 2, 4, 3, 1));
        TreeNode root = new BTFromInAndPostorder().buildTree(inOrder, postOrder);
        new PreOrderTraversal().solve(root).forEach(i -> System.out.print(i + " "));
    }

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        return constructTree(A, B);
    }

    private TreeNode constructTree(List<Integer> inOrder, List<Integer> postOrder) {
        if (inOrder.size() == 0 || postOrder.size() == 0) return null;
        if (inOrder.size() == 1) {
            postOrder.remove(postOrder.size() - 1);
            return new TreeNode(inOrder.get(0));
        }

        int p = postOrder.size();
        int pValue = postOrder.get(p - 1);
        postOrder.remove(p - 1);
        TreeNode root = new TreeNode(pValue);
        int inIndex = -1;
        for (int i = 0; i < inOrder.size(); i++) {
            if (inOrder.get(i) == pValue) {
                inIndex = i;
                break;
            }
        }

        root.right = constructTree(inOrder.subList(inIndex + 1, inOrder.size()), postOrder);
        root.left = constructTree(inOrder.subList(0, inIndex), postOrder);
        return root;
    }
}
