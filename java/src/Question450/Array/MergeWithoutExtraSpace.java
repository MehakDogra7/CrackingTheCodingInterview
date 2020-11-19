package Question450.Array;

//TODO : O(1) space
public class MergeWithoutExtraSpace {
    public static void main(String[] args) {
        int[] A = {1, 1, 1, 2, 3, 5, 7, 7, 7, 9, 9, 12, 12, 14, 14, 17, 17, 19, 20, 20};
        int[] B = {3, 5, 7, 9, 10, 12, 13, 14, 20, 20};

        new MergeWithoutExtraSpace().merge(A, B, A.length, B.length);
        for (int i : A) {
            System.out.print(i + " ");
        }
        for (int i : B) {
            System.out.print(i + " ");
        }
    }

    public void merge(int A[], int B[], int n, int m) {
        // code here
        int gap = (n + m + 1) / 2;
        while (true) {
            for (int i = 0; i < (n + m - gap); i++) {
                int start = i, end = start + gap;
                if (start < n && end < n) {
                    if (A[start] > A[end]) {
                        int temp = A[start];
                        A[start] = A[end];
                        A[end] = temp;
                    }
                } else if (start >= n && end >= n) {
                    start -= n;
                    end -= n;
                    if (B[start] > B[end]) {
                        int temp = B[start];
                        B[start] = B[end];
                        B[end] = temp;
                    }
                } else {
                    end -= n;
                    if (A[start] > B[end]) {
                        int temp = A[start];
                        A[start] = B[end];
                        B[end] = temp;
                    }
                }
            }
            if (gap == 1) break;
            gap = (gap + 1) / 2;
        }
    }
}
