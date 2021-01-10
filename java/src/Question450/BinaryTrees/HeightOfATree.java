package Question450.BinaryTrees;

public class HeightOfATree {

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);

        a.left = b;
        a.right = c;

        System.out.println(new HeightOfATree().height(a));
    }

    int height(Node node) {
        // code here
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
