package Question450.Array;

public class MoveAllNegToBeg {

    public static void main(String[] args) {
        int[] A = {-12, 11, -13, -5, 6, -7, 5, -3, -6};

        move(A);
        for (int i : A) {
            System.out.print(i + " ");
        }
    }

    private static void move(int[] A) {
        int i = -1, j = 0;

        while (j < A.length) {
            if (A[j] < 0) {
                swap(A, ++i, j);
            }
            j++;
        }
        swap(A, ++i, A.length - 1);
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
