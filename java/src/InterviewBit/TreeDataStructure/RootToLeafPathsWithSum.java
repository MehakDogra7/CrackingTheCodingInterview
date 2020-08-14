package InterviewBit.TreeDataStructure;

import java.util.ArrayList;

public class RootToLeafPathsWithSum {

    public static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(11);
        TreeNode e = new TreeNode(13);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(2);
        TreeNode i = new TreeNode(5);
        TreeNode j = new TreeNode(1);

        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        d.left = g;
        d.right = h;
        f.left = i;
        f.right = j;

        ArrayList<ArrayList<Integer>> solve = new RootToLeafPathsWithSum().pathSum(a, 22);
        solve.forEach(x -> {
            x.forEach(y -> System.out.print(y + " "));
            System.out.println();
        });
    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        result.clear();
        find(A, B, new ArrayList<>());
        return result;
    }

    private int find(TreeNode curr, int B, ArrayList<Integer> list) {
        if (curr == null) return 0;
        if (curr.left == null && curr.right == null) {
            if (curr.val == B) {
                ArrayList<Integer> temp = new ArrayList<>(list);
                temp.add(curr.val);
                result.add(temp);
                return 1;
            }
            return 0;
        }

        ArrayList<Integer> temp = new ArrayList<>(list);
        temp.add(curr.val);
        int l = find(curr.left, B - curr.val, temp);
        int r = find(curr.right, B - curr.val, temp);
        if (l == 0 && r == 0) {
            return 0;
        }
        return 1;
    }
}
