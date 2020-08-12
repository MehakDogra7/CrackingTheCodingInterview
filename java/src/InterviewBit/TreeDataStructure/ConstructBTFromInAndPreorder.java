package InterviewBit.TreeDataStructure;

import java.util.ArrayList;
import java.util.List;

public class ConstructBTFromInAndPreorder {

    public static void main(String[] args) {
        ArrayList<Integer> inOrder = new ArrayList<>(List.of(5, 2, 1, 4, 3));
        ArrayList<Integer> preOrder = new ArrayList<>(List.of(1, 2, 5, 3, 4));
        TreeNode root = new ConstructBTFromInAndPreorder().buildTree(inOrder, preOrder);
        new PostOrderTraversal().solve(root).forEach(i -> System.out.print(i + " "));
    }

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        return constructTree(A, B);
    }

    private TreeNode constructTree(List<Integer> inOrder, List<Integer> preOrder) {
        if (inOrder.size() == 0 || preOrder.size() == 0) return null;
        if (inOrder.size() == 1) {
            preOrder.remove(0);
            return new TreeNode(inOrder.get(0));
        }

        int pValue = preOrder.get(0);
        preOrder.remove(0);
        TreeNode root = new TreeNode(pValue);
        int inIndex = -1;
        for (int i = 0; i < inOrder.size(); i++) {
            if (inOrder.get(i) == pValue) {
                inIndex = i;
                break;
            }
        }

        root.left = constructTree(inOrder.subList(0, inIndex), preOrder);
        root.right = constructTree(inOrder.subList(inIndex + 1, inOrder.size()), preOrder);
        return root;
    }
}
