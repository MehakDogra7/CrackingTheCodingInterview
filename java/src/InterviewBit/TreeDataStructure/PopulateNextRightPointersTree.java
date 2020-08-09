package InterviewBit.TreeDataStructure;

import java.util.ArrayList;

public class PopulateNextRightPointersTree {

    public static void main(String[] args) {

        TreeLinkNode a = new TreeLinkNode(1);
        TreeLinkNode b = new TreeLinkNode(2);
        TreeLinkNode c = new TreeLinkNode(3);
        TreeLinkNode d = new TreeLinkNode(4);
        TreeLinkNode e = new TreeLinkNode(5);
        TreeLinkNode f = new TreeLinkNode(6);
        TreeLinkNode g = new TreeLinkNode(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        System.out.println("Hello");
        new PopulateNextRightPointersTree().connect(a);
        System.out.println("Hello");
    }

    /**
     * T.C. O(n)
     * S.C. O(n)
     *
     * @param root
     */
    public void connect(TreeLinkNode root) {
        ArrayList<ListObject> list = new ArrayList<>();
        ListObject curr = new ListObject(0, root);
        list.add(curr);
        int i = 1;
        while (true) {
            TreeLinkNode currNode = curr.node;
            int currLevel = curr.level;

            if (currNode.left != null) list.add(new ListObject(currLevel + 1, currNode.left));
            if (currNode.right != null) list.add(new ListObject(currLevel + 1, currNode.right));

            if (i == list.size()) break;
            curr = list.get(i++);
        }

        i = 1;
        while (i < list.size()) {
            int j = i + 1;
            TreeLinkNode prev = list.get(i).node;
            int currLevel = list.get(i).level;
            while (j < list.size() && list.get(j).level == currLevel) {
                prev.next = list.get(j).node;
                prev = list.get(j).node;
                j++;
            }
            i = j;
        }
    }

    /**
     * T.C. O(n)
     * S.C. O(1)
     *
     * @param root
     */
    public void connectOptimized(TreeLinkNode root) {
        //TODO

    }

    static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    static class ListObject {
        Integer level;
        TreeLinkNode node;

        public ListObject(Integer level, TreeLinkNode node) {
            this.level = level;
            this.node = node;
        }
    }
}
