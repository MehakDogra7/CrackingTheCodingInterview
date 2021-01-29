package Question450.Heap;

public class HeapSort {
    public static void main(String[] args) {
        int[] input = {4, 1, 5, 2, 6, 3};
        heapSort(input);
        for (int val : input) {
            System.out.print(val + " ");
        }
    }

    private static void heapSort(int[] input) {
        buildHeap(input);
        int heapSize = input.length;
        while (heapSize > 1) {
            swap(input, 0, heapSize - 1);
            heapSize--;
            maxHeapify(input, 0, heapSize);
        }
    }

    private static void buildHeap(int[] input) {
        int n = input.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            maxHeapify(input, i, input.length);
        }
    }

    private static void maxHeapify(int[] input, int i, int heapSize) {
        while (i < heapSize) {
            int largest = i;
            if ((2 * i + 1) < heapSize && input[2 * i + 1] > input[largest])
                largest = 2 * i + 1;
            if ((2 * i + 2) < heapSize && input[2 * i + 2] > input[largest])
                largest = 2 * i + 2;
            if (i == largest) return;
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
