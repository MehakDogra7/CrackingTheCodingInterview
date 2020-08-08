package InterviewBit.TreeDataStructure;

import java.util.*;

public class VerticalOrderTraversalOfBT {

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

        new VerticalOrderTraversalOfBT().verticalOrderTraversal(a).forEach(i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null) return result;

        map = new LinkedHashMap<>();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        levelOrderTraversal(A);

        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }

        return result;
    }

    public void levelOrderTraversal(TreeNode node) {
        Integer i = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<Integer> queue2 = new ArrayDeque<>();

        TreeNode curr = node;
        queue.add(curr);
        queue2.add(i);

        while (curr != null) {
            min = Integer.min(min, i);
            max = Integer.max(max, i);

            if (curr.left != null) {
                queue.add(curr.left);
                queue2.add(i - 1);
            }
            if (curr.right != null) {
                queue.add(curr.right);
                queue2.add(i + 1);
            }

            if (map.containsKey(i)) {
                map.get(i).add(curr.val);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(curr.val);
                map.put(i, temp);
            }

            queue.poll();
            queue2.poll();
            curr = queue.peek();
            i = queue2.peek();
        }

    }

}
