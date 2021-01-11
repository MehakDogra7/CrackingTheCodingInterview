package Question450.BinaryTrees;

public class ConstructBinaryTreeFromString {

    public static void main(String[] args) {
        Node root = new ConstructBinaryTreeFromString().solve("4(2(3)(1))(6(5))");
        new PreOrderTraversal().getPreOrder(root).forEach(i -> System.out.print(i + " "));
    }

    private Node solve(String A) {

        return construct(A);
    }

    private Node construct(String a) {
        if (0 == a.length()) return null;
        if (1 == a.length()) return new Node(a.charAt(0) - 48);

        Node curr = new Node(a.charAt(0) - 48);
        int start = 2;
        int count = 1, end = 2;
        while (end < a.length() && count > 0) {
            if (a.charAt(end) == '(') count++;
            else if (a.charAt(end) == ')') count--;
            end++;
        }
        end--;
        curr.left = start == end ? null : construct(a.substring(start, end));
        count = 1;
        start = end + 2;
        end = start;
        while (end < a.length() && count > 0) {
            if (a.charAt(end) == '(') count++;
            else if (a.charAt(end) == ')') count--;
            end++;
        }
        end--;
        curr.right = start >= end ? null : construct(a.substring(start, end));
        return curr;
    }
}
