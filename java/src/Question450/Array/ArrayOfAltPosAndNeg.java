package Question450.Array;

import java.util.ArrayList;

public class ArrayOfAltPosAndNeg {

    public static void main(String[] args) {
        int[] A = {-3, 4, 5, 6, 7, -1};
        new ArrayOfAltPosAndNeg().rearrange(A, A.length);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

    void rearrange(int A[], int n) {
        // code here
        if (n < 2) return;

        ArrayList<Integer> positiveIndex = new ArrayList<>();
        ArrayList<Integer> negativeIndex = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (A[i] >= 0) positiveIndex.add(i);
            else negativeIndex.add(i);
        }

        int[] res = new int[n];

        int i = 0, j = 0, k = 0;
        while (i < positiveIndex.size() && j < negativeIndex.size()) {
            res[k++] = A[positiveIndex.get(i++)];
            res[k++] = A[negativeIndex.get(j++)];
        }

        while (i < positiveIndex.size()) {
            res[k++] = A[positiveIndex.get(i++)];
        }

        while (j < negativeIndex.size()) {
            res[k++] = A[negativeIndex.get(j++)];
        }

        for (i = 0; i < n; i++) {
            A[i] = res[i];
        }
    }
}
