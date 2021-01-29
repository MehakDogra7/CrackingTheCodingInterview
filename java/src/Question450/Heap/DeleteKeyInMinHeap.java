package Question450.Heap;

import java.util.ArrayList;
import java.util.List;

public class DeleteKeyInMinHeap {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(List.of(1, 2, 3, 4, 6, 5));
        new DeleteKeyInMinHeap().deleteKey(input, 2);
        input.forEach(i -> System.out.print(i + " "));
    }

    private void deleteKey(ArrayList<Integer> input, int valToDelete) {
        int index = -1;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) == valToDelete) {
                index = i;
                break;
            }
        }
        if (index == -1) return;
        int n = input.size();

        swap(input, index, n - 1);
        input.remove(n - 1);
        minHeapify(input, index);
    }

    private void minHeapify(ArrayList<Integer> input, int index) {
        int i = index, n = input.size();
        while (i < n) {
            int smallest = i;
            if ((2 * i + 1) < n && input.get(2 * i + 1) < input.get(smallest))
                smallest = 2 * i + 1;
            if ((2 * i + 2) < n && input.get(2 * i + 2) < input.get(smallest))
                smallest = 2 * i + 2;
            if (smallest == i) break;
            swap(input, smallest, i);
            i = smallest;
        }
    }


    private void swap(ArrayList<Integer> input, int i, int j) {
        int temp = input.get(i);
        input.set(i, input.get(j));
        input.set(j, temp);
    }


}
