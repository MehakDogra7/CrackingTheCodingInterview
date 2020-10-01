package InterviewBit.DynamicProgramming;

import InterviewBit.TreeDataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HouseRobber3 {

    Map<MapObject, Integer> dp;

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(1);

        a.left = b;
        a.right = c;
        b.right = d;
        c.right = e;

        System.out.println(new HouseRobber3().rob(a));
    }

    public int rob(TreeNode root) {

        dp = new HashMap<>();
        int considerRoot = topDown(root, 'p', 0, true);
        int dontConsiderRoot = topDown(root, 'p', 0, false);

        return Math.max(considerRoot, dontConsiderRoot);
    }

    private int topDown(TreeNode node, char side, int level, boolean include) {
        if (node == null) return 0;

        MapObject mapObject = new MapObject(node.val, level, side, include);

        if (dp.containsKey(mapObject)) return dp.get(mapObject);

        int ans = 0;

        int left = topDown(node.left, 'l', level + 1, true);
        int right = topDown(node.right, 'r', level + 1, true);
        ans = left + right;

        if (include) {
            left = topDown(node.left, 'l', level + 1, false);
            right = topDown(node.right, 'r', level + 1, false);
            ans = Math.max(ans, node.val + left + right);
        }

        dp.put(mapObject, ans);
        return ans;
    }

    static class MapObject {
        int value, level;
        char side;
        boolean include;

        public MapObject(int value, int level, char side, boolean include) {
            this.value = value;
            this.level = level;
            this.side = side;
            this.include = include;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MapObject mapObject = (MapObject) o;
            return value == mapObject.value &&
                    level == mapObject.level &&
                    side == mapObject.side &&
                    include == mapObject.include;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, level, side, include);
        }
    }
}
