package Question450.SearchingAndSorting;

import java.util.ArrayList;

public class ValueEqualToIndexValue {

    public static void main(String[] args) {
        int[] A = {15, 2, 45, 12, 7};
        ArrayList<Integer> result = new ValueEqualToIndexValue().valueEqualToIndex(A, A.length);
        result.forEach(System.out::println);
    }

    public ArrayList<Integer> valueEqualToIndex(int A[], int n) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (A[i] == i + 1) result.add(i + 1);
        }
        return result;
    }
}
