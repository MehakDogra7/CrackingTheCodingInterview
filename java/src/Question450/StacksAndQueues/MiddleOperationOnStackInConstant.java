package Question450.StacksAndQueues;

public class MiddleOperationOnStackInConstant {

    StackNode top;
    StackNode middle;
    boolean incrementMiddle;
    boolean decrementMiddle;

    public MiddleOperationOnStackInConstant() {
        incrementMiddle = true;
        decrementMiddle = true;
    }

    public static void main(String[] args) {
        MiddleOperationOnStackInConstant stack = new MiddleOperationOnStackInConstant();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Middle Element: " + stack.findMiddle());
        System.out.println("Deleted Middle Element: " + stack.deleteMiddle());
        System.out.println("Middle Element: " + stack.findMiddle());
        System.out.println("Popped Element: " + stack.pop());
        System.out.println("Middle Element: " + stack.findMiddle());
        System.out.println("Deleted Middle Element: " + stack.deleteMiddle());
        System.out.println("Middle Element: " + stack.findMiddle());
        stack.push(2);
        stack.push(3);
        stack.push(5);
        System.out.println("Middle Element: " + stack.findMiddle());
    }

    public void push(int x) {
        StackNode newNode = new StackNode(x);
        if (top == null) {
            top = newNode;
            middle = newNode;
            return;
        }
        newNode.next = top;
        top.prev = newNode;
        top = newNode;
        if (incrementMiddle) middle = middle.prev;
        incrementMiddle = !incrementMiddle;
    }

    public int pop() {
        if (top == null) {
            return -1;
        }

        int pop = top.data;
        top = top.next;
        if (top == null) {
            middle = null;
            return pop;
        }

        top.prev = null;

        if (decrementMiddle) middle = middle.next;
        decrementMiddle = !decrementMiddle;
        return pop;
    }

    public int findMiddle() {
        if (middle == null) return -1;
        return middle.data;
    }

    public int deleteMiddle() {
        if (middle == null) return -1;
        int data = middle.data;

        if (middle == top) {
            middle = middle.next;
            middle.prev = null;
            top = middle;
        } else {
            StackNode prev = middle.prev;
            middle = middle.next;
            middle.prev = prev;
            prev.next = middle;
        }
        if (decrementMiddle) decrementMiddle = false;
        return data;
    }

    static class StackNode {
        int data;
        StackNode prev, next;

        public StackNode(int data) {
            this.data = data;
        }
    }
}
