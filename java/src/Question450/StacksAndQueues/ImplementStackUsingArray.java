package Question450.StacksAndQueues;

public class ImplementStackUsingArray {

    int top;
    int[] arr = new int[1000];

    public ImplementStackUsingArray() {
        top = -1;
    }

    public static void main(String[] args) {
        ImplementStackUsingArray obj = new ImplementStackUsingArray();
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop());
        obj.push(4);
        System.out.println(obj.pop());
    }

    /* The method push to push element
        into the stack */
    void push(int a) {
        // Your code here
        if (top == 999) return;
        arr[++top] = a;
    }

    /* The method pop which return
      the element poped out of the stack*/
    int pop() {
        // Your code here
        if (top == -1) return -1;
        return arr[top--];
    }

}
