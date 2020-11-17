package Question450.Array;

public class MinAndMaxInMinComp {
    public static void main(String[] args) {
        int[] A = {2, 4, 1, 9, 10, 13};
        int[] res = new MinAndMaxInMinComp().solve(A);
        for (int re : res) {
            System.out.println(re);
        }
    }

    private int[] solve(int[] A) {
        int min, max, n = A.length, i;

        if ((n & 1) == 1) {
            min = A[0];
            max = A[0];
            i = 1;
        } else {
            if (A[0] < A[1]) {
                min = A[0];
                max = A[1];
            } else {
                min = A[1];
                max = A[0];
            }
            i = 2;
        }

        for (; i < n - 1; i += 2) {
            if (A[i] < A[i + 1]) {
                if (A[i] < min)
                    min = A[i];
                if (A[i + 1] > max)
                    max = A[i + 1];
            } else {
                if (A[i + 1] < min)
                    min = A[i + 1];
                if (A[i] > max)
                    max = A[i];
            }
        }

        int[] res = new int[2];
        res[0] = min;
        res[1] = max;
        return res;
    }
}
