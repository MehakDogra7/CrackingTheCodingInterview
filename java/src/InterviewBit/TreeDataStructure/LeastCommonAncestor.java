package InterviewBit.TreeDataStructure;

import java.util.ArrayList;

public class LeastCommonAncestor {

    ArrayList<Integer> trace = new ArrayList<>();

    public static void main(String[] args) {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(10);
        TreeNode i = new TreeNode(11);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = h;
        d.right = i;
        System.out.println(new LeastCommonAncestor().lca(a, 10, 11));
    }

    public int lca(TreeNode A, int B, int C) {

        ArrayList<Integer> traceForB = new ArrayList<>();
        ArrayList<Integer> traceForC = new ArrayList<>();

        int b = trace(A, traceForB, B);
        traceForB = new ArrayList<>(trace);
        int c = trace(A, traceForC, C);
        traceForC = new ArrayList<>(trace);

        if (b == -1 || c == -1) return -1;

        int min = Integer.min(traceForB.size(), traceForC.size());
        int ans = -1;
        for (int i = 0; i < min; i++) {
            if (traceForB.get(i).equals(traceForC.get(i))) {
                ans = traceForB.get(i);
            }
        }
        return ans;
    }

    private int trace(TreeNode curr, ArrayList<Integer> list, int num) {
        if (curr == null) return -1;
        if (curr.val == num) {
            list.add(num);
            trace = new ArrayList<>(list);
            return 1;
        }
        if (curr.left == null && curr.right == null) {
            return -1;
        }
        ArrayList<Integer> temp = new ArrayList<>(list);
        temp.add(curr.val);
        int l = trace(curr.left, temp, num);
        if (l == 1) {
            list.add(curr.val);
            return 1;
        }
        int r = trace(curr.right, temp, num);
        if (r == 1) {
            list.add(curr.val);
            return 1;
        }
        return -1;
    }
}
