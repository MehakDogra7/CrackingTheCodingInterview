package Question450.Heap;

import java.util.ArrayList;
import java.util.List;

public class InsertKeyInMinHeap {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(List.of(1, 2, 3, 4, 6, 5));

        new InsertKeyInMinHeap().insert(input, 0);
        input.forEach(i -> System.out.print(i + " "));
    }

    private void insert(ArrayList<Integer> input, int val) {
        input.add(val);
        int n = input.size();
        if (n < 2) return;

        //Bottom up Heapify
        int i = n - 1;
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (parent >= 0 && input.get(parent) > input.get(i)) {
                swap(input, parent, i);
                i = parent;
            } else break;
        }
    }

    private void swap(ArrayList<Integer> input, int i, int j) {
        int temp = input.get(i);
        input.set(i, input.get(j));
        input.set(j, temp);
    }
}
