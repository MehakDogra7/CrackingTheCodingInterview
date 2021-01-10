package Question450.BinaryTrees;

import java.util.ArrayList;

public class CreateMirrorTree {

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);

        a.left = b;
        a.right = c;

        ArrayList<Integer> preOrderOrig = new PreOrderTraversal().getPreOrder(a);
        preOrderOrig.forEach(i -> System.out.print(i + " "));
        System.out.println();
        Node root = createMirrorTree(a);
        ArrayList<Integer> preOrder = new PreOrderTraversal().getPreOrder(root);
        preOrder.forEach(i -> System.out.print(i + " "));
    }

    private static Node createMirrorTree(Node a) {

        Node mirroredRoot = new Node(a.data);
        createMirrorTree(a, mirroredRoot);
        return mirroredRoot;
    }

    private static void createMirrorTree(Node orig, Node mirrored) {
        if (orig == null) return;

        mirrored.left = orig.right == null ? null : new Node(orig.right.data);
        mirrored.right = orig.left == null ? null : new Node(orig.left.data);

        createMirrorTree(orig.left, mirrored.right);
    }
}
