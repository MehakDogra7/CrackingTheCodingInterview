package Question450.Heap;

import java.util.ArrayList;
import java.util.List;

public class ExtractMin {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(List.of(1, 2, 3, 4, 6, 5));

        System.out.println("Minimum is: " + new ExtractMin().extractMin(input));
        input.forEach(i -> System.out.print(i + " "));
    }

    private int extractMin(ArrayList<Integer> input) {
        if (input.size() == 0) return -1;
        int n = input.size();

        int ans = input.get(0);
        input.set(0, input.get(n - 1));
        input.remove(n - 1);
        minHeapify(input, n - 1, 0);

        return ans;
    }

    private void minHeapify(ArrayList<Integer> input, int n, int i) {
        while (i < n) {
            int smallest = i;
            if ((2 * i + 1) < n && input.get(2 * i + 1) < input.get(smallest))
                smallest = 2 * i + 1;
            if ((2 * i + 2) < n && input.get(2 * i + 2) < input.get(smallest))
                smallest = 2 * i + 2;
            if (smallest == i) break;
            swap(input, i, smallest);
            i = smallest;
        }
    }

    private void swap(ArrayList<Integer> input, int i, int j) {
        int temp = input.get(i);
        input.set(i, input.get(j));
        input.set(j, temp);
    }
}
