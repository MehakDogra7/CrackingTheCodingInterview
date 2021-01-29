package Question450.Heap;

public class BuildMinHeap {
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
            minHeapify(input, n, i);
        }
    }

    private static void minHeapify(int[] input, int n, int i) {
        while (i < n) {
            int smallest = i;
            if ((2 * i + 1) < n && input[2 * i + 1] < input[smallest])
                smallest = 2 * i + 1;
            if ((2 * i + 2) < n && input[2 * i + 2] < input[smallest])
                smallest = 2 * i + 2;
            if (smallest == i) break;
            swap(input, i, smallest);
            i = smallest;
        }
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
