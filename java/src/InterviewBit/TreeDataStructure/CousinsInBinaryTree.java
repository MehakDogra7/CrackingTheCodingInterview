package InterviewBit.TreeDataStructure;

import java.util.ArrayList;

public class CousinsInBinaryTree {

    public static void main(String[] args) {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        //TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        //TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);

        a.left = b;
        a.right = c;
        //b.left = d;
        b.right = e;
        //c.left = f;
        c.right = g;

        new CousinsInBinaryTree().solve(a, 5).forEach(i -> System.out.print(i + " "));
    }

    public ArrayList<Integer> solve(TreeNode A, int B) {
        if (A == null || B == A.val) return new ArrayList<>();

        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<QueueObject> list = new ArrayList<>();
        TreeNode node = A;
        QueueObject curr = new QueueObject(0, node);
        list.add(curr);
        int requiredLevel = Integer.MIN_VALUE;
        int i = 1;

        while (true) {
            int level = curr.level;
            if (curr.node.val == B) {
                requiredLevel = level;
            }
            if (level == requiredLevel + 1) {
                break;
            }
            TreeNode left = curr.node.left == null ? new TreeNode(-1) : curr.node.left;
            TreeNode right = curr.node.right == null ? new TreeNode(-1) : curr.node.right;

            list.add(new QueueObject(level + 1, left));
            list.add(new QueueObject(level + 1, right));
            curr = list.get(i++);
        }

        int start = (int) (Math.pow(2, requiredLevel) - 1);
        int end = (int) (Math.pow(2, requiredLevel + 1) - 1);

        for (int j = start; j < end; j++) {
            if (list.get(j).node != null) {
                temp.add(list.get(j).node.val);
            }
        }

        for (int j = 0; j < temp.size(); j++) {
            if (temp.get(j) == B) {
                if ((j & 1) == 1) {
                    temp.remove(j - 1);
                    temp.remove(j - 1);
                } else {
                    temp.remove(j);
                    temp.remove(j);
                }
                break;
            }
        }

        int j = 0;
        while (j < temp.size()) {
            if (temp.get(j) == -1) temp.remove(j);
            else j++;
        }

        return temp;
    }

    class QueueObject {
        Integer level;
        TreeNode node;

        public QueueObject(Integer level, TreeNode node) {
            this.level = level;
            this.node = node;
        }


    }
}
