package InterviewBit.TreeDataStructure;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiagonalTraversal {

    Map<Integer, ArrayList<Integer>> map;
    int min;
    int max;

    public static void main(String[] args) {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        new DiagonalTraversal().solve(a).forEach(i -> System.out.print(i + " "));
    }

    public ArrayList<Integer> solve(TreeNode A) {
        if (A == null) return new ArrayList<>();

        map = new LinkedHashMap<>();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        ArrayList<Integer> result = new ArrayList<>();
        preOrderTraversal(A, 0);
        for (int i = min; i <= max; i++) {
            result.addAll(map.get(i));
        }

        return result;
    }

    public void preOrderTraversal(TreeNode curr, int i) {
        if (curr == null) return;

        min = Integer.min(i, min);
        max = Integer.max(i, max);

        if (map.containsKey(i)) {
            map.get(i).add(curr.val);
        } else {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(curr.val);
            map.put(i, temp);
        }

        preOrderTraversal(curr.left, i + 1);
        preOrderTraversal(curr.right, i);
    }
}
