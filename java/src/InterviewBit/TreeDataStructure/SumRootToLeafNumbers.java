package InterviewBit.TreeDataStructure;

public class SumRootToLeafNumbers {

    public static long sum = 0;

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

        System.out.println(new SumRootToLeafNumbers().sumNumbers(a));
    }

    public int sumNumbers(TreeNode A) {
        sum = 0;
        findSum(A, "");
        return (int) (sum % 1003);
    }

    private void findSum(TreeNode curr, String numTillNow) {
        if (curr == null) return;
        if (curr.left == null && curr.right == null) {
            numTillNow += curr.val;
            sum += (Integer.parseInt(numTillNow)) % 1003;
            return;
        }

        numTillNow += curr.val;
        numTillNow = String.valueOf(Integer.parseInt(numTillNow) % 1003);
        findSum(curr.left, numTillNow);
        findSum(curr.right, numTillNow);
    }
}
