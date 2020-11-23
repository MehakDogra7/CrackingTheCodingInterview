package Question450.Array;

public class ThreeWayPartition {

    public static void main(String[] args) {
        int[] array = {28, 83, 22, 94, 35, 40, 35, 22, 60, 86, 58, 55, 62};
        int a = 13, b = 35;
        new ThreeWayPartition().threeWayPartition(array, a, b);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public void threeWayPartition(int array[], int a, int b) {
        // code here
        int pivot = partiton(array, 0, array.length - 1, a);
        partiton(array, pivot + 1, array.length - 1, b);
    }

    private int partiton(int[] A, int low, int high, int pivot) {

        for (int i = low; i <= high; i++) {
            if (A[i] == pivot) {
                swap(A, i, high);
                break;
            }
        }

        int i = low - 1, j = low;
        while (j <= high) {
            if (A[j] < pivot) {
                swap(A, ++i, j);
            }
            j++;
        }

        for (int k = low; k <= high; k++) {
            if (A[k] == pivot) {
                swap(A, ++i, k);
            }
        }
        return i;
    }

    private void swap(int[] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }
}
