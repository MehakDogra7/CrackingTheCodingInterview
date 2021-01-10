package Question450.BinaryTrees;

import java.util.ArrayList;

public class PreOrderTraversal {

    private ArrayList<Integer> preOrder = new ArrayList<>();

    public ArrayList<Integer> getPreOrder(Node node) {

        generatePreOrder(node);
        return preOrder;
    }

    private void generatePreOrder(Node node) {
        if(node == null) return;
        preOrder.add(node.data);
        generatePreOrder(node.left);
        generatePreOrder(node.right);
    }
}
