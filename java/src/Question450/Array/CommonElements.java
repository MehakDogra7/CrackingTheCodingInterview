package Question450.Array;

import java.util.ArrayList;

public class CommonElements {

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {1, 2};
        int[] C = {2};
        ArrayList<Integer> list = new CommonElements().commonElements(A, B, C, A.length, B.length, C.length);
        list.forEach(System.out::println);
    }

    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) {
        // code here
        int i = 0, j = 0, k = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while (i < n1 && j < n2 && k < n3) {
            if (A[i] == B[j] && B[j] == C[k]) {
                if (res.size() == 0 || A[i] != res.get(res.size() - 1)) res.add(A[i]);
                i++;
                j++;
                k++;
            } else if (A[i] <= B[j] && A[i] <= C[k]) i++;
            else if (B[j] <= A[i] && B[j] <= C[k]) j++;
            else k++;
        }
        return res;
    }
}
