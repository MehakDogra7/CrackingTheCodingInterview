package InterviewBit.TreeDataStructure;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversalOfCartesianTree {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(3, 5, 2, 4, 1));
        TreeNode node = new InorderTraversalOfCartesianTree().buildTree(A);
        new PreOrderTraversal().solve(node).forEach(i -> System.out.print(i + " "));
        System.out.println();
        new InOrderTraversal().solve(node).forEach(i -> System.out.print(i + " "));
        System.out.println();
        new PostOrderTraversal().solve(node).forEach(i -> System.out.print(i + " "));
    }

    public TreeNode buildTree(ArrayList<Integer> A) {
        return constructTree(A);
    }

    private TreeNode constructTree(List<Integer> curr) {
        if (curr.size() == 0) return null;
        if (curr.size() == 1) return new TreeNode(curr.get(0));
        int maxIndex = getMaxIndex(curr);
        TreeNode root = new TreeNode(curr.get(maxIndex));
        root.left = constructTree(curr.subList(0, maxIndex));
        root.right = constructTree(curr.subList(maxIndex + 1, curr.size()));
        return root;
    }

    private int getMaxIndex(List<Integer> curr) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < curr.size(); i++) {
            if (max < curr.get(i)) {
                max = curr.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
