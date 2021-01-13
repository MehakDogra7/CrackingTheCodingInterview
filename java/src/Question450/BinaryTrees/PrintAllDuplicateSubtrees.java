package Question450.BinaryTrees;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PrintAllDuplicateSubtrees {

    int t;
    Map<Integer, Integer> count;
    Map<String, Integer> trees;
    Set<Integer> ans;

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(2);
        Node f = new Node(4);
        Node g = new Node(4);

        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        e.left = g;

        new PrintAllDuplicateSubtrees().printDup(a);
    }

    public void printDup(Node root){
        //Write your code here
        t = 1;
        count = new HashMap<>();
        trees = new HashMap<>();
        ans = new TreeSet<>();
        lookup(root);

        if(ans.isEmpty()){
            System.out.print("-1");
        }
        else{
            for(Integer i : ans){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private int lookup(Node curr) {
        if (curr == null) return 0;
        String serial = curr.data + "," + lookup(curr.left) + "," + lookup(curr.right);

        if (!trees.containsKey(serial)) trees.put(serial, t++);
        int uid = trees.get(serial);

        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2) ans.add(curr.data);

        return uid;
    }
}
