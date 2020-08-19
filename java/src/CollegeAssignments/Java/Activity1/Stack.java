package CollegeAssignments.Java.Activity1;

public class Stack {

    private LinkedList list;

    public void push(String stringToAdd) {
        if (list == null) list = new LinkedList(stringToAdd);
        else list.add(stringToAdd);
    }

    public String pop() {
        return list.remove();
    }

    public boolean isEmpty() {
        return list == null || list.isEmpty();
    }
}

class LinkedList {

    private ListNode root;

    public LinkedList(String rootValue) {
        this.root = new ListNode(rootValue, null);
    }

    public void add(String stringToAdd) {
        ListNode node = new ListNode(stringToAdd, null);
        node.next = root;
        root = node;
    }

    public String remove() {
        if (isEmpty()) return "-1";
        String stringToRemove = root.val;
        root = root.next;
        return stringToRemove;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public static class ListNode {
        private final String val;
        private ListNode next;

        public ListNode(String val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

class StackUtilTest {

    public static void main(String[] args) {
        Stack stack = new Stack();
        String sentence = "World Health Organisation";
        StringBuilder res = new StringBuilder();
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            stack.push(s[i]);
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop()).append(" ");
        }
        System.out.println(res.toString().trim());
    }
}
