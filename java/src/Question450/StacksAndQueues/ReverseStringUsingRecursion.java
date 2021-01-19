package Question450.StacksAndQueues;

public class ReverseStringUsingRecursion {

    public static void main(String[] args) {
        String A = "Hello";
        System.out.println(new ReverseStringUsingRecursion().reverse(A));
    }

    private String reverse(String A) {
        if (A.length() == 1) return A;
        return reverse(A.substring(1)) + A.charAt(0);
    }
}
