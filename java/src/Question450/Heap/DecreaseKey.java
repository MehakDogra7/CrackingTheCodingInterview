package Question450.Heap;

public class DecreaseKey {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 6, 5};
        decreaseKey(input, 3, 0);
        for (int val : input) {
            System.out.print(val + " ");
        }
    }

    private static void decreaseKey(int[] input, int index, int val) {
        input[index] = val;
        int i = index;
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (parent >= 0 && input[parent] > input[i]) {
                swap(input, parent, i);
                i = parent;
            } else break;
        }
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
