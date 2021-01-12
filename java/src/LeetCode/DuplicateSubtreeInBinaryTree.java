package LeetCode;


import InterviewBit.TreeDataStructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateSubtreeInBinaryTree {

    int t;
    Map<Integer, Integer> count;
    Map<String, Integer> trees;
    List<TreeNode> ans;

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(4);

        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        e.left = g;


        List<TreeNode> result = new DuplicateSubtreeInBinaryTree().findDuplicateSubtrees(a);
        result.forEach(i -> System.out.println(i.val));
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        // code here
        t = 1;
        count = new HashMap<>();
        trees = new HashMap<>();
        ans = new ArrayList<>();
        lookup(root);

        System.out.println("---Count------");
        count.forEach((x, y) -> System.out.println("Key: " + x + " value: " + y));
        System.out.println("---Trees------");
        trees.forEach((x, y) -> System.out.println("Key: " + x + " value: " + y));
        System.out.println("---Ans------");
        return ans;
    }

    private int lookup(TreeNode curr) {
        if (curr == null) return 0;
        String serial = curr.val + "," + lookup(curr.left) + "," + lookup(curr.right);

        if (!trees.containsKey(serial)) trees.put(serial, t++);
        int uid = trees.get(serial);

        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2) ans.add(curr);

        return uid;
    }
}

