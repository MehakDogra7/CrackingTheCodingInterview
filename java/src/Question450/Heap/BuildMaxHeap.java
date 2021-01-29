package Question450.Heap;

public class BuildMaxHeap {

    public static void main(String[] args) {
        int[] input = {4, 1, 5, 2, 6, 3};
        buildHeap(input);
        for (int val : input) {
            System.out.print(val + " ");
        }
    }

    private static void buildHeap(int[] input) {
        if (input.length < 2) return;
        int n = input.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            maxHeapify(input, n, i);
        }
    }

    private static void maxHeapify(int[] input, int n, int i) {
        while (i < n) {
            int largest = i;
            if ((2 * i + 1) < n && input[2 * i + 1] > input[largest])
                largest = 2 * i + 1;
            if ((2 * i + 2) < n && input[2 * i + 2] > input[largest])
                largest = 2 * i + 2;
            if (largest == i) break;
            swap(input, i, largest);
            i = largest;
        }
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
