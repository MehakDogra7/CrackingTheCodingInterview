package Question450.Array;

public class ReverseAnArray {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6};
        int[] B = {1, 2, 3, 4, 5};

        new ReverseAnArray().reverseArray(A);
        new ReverseAnArray().reverseArray(B);

        for (int i : A) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : B) {
            System.out.print(i + " ");
        }
    }

    private void reverseArray(int[] A) {
        for (int i = 0, j = A.length - 1; i < j; i++, j--) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

    private String reverseString(String A) {
        StringBuilder res = new StringBuilder();
        for (int i = A.length()-1; i >= 0; i--) {
            res.append(A.charAt(i));
        }
        return res.toString();
    }
}
