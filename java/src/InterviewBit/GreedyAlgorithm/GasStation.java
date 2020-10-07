package InterviewBit.GreedyAlgorithm;

public class GasStation {
    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {2, 1};
        System.out.println(new GasStation().canCompleteCircuit(A, B));
        System.out.println(new GasStation().canCompleteCircuitOptimal(A, B));
    }

    public int canCompleteCircuitOptimal(final int[] A, final int[] B) {
        int start = 0, end = 0, n = A.length, availableGas = 0;

        int totalGas = 0, totalCost = 0;
        for (int j = 0; j < A.length; j++) {
            totalCost += B[j];
            totalGas += A[j];
        }
        if (totalCost > totalGas) return -1;

        while (end < n) {
            availableGas += A[end] - B[end];
            if (availableGas < 0) {
                start = end + 1;
                availableGas = 0;
            }
            end++;
        }
        return start;
    }

    public int canCompleteCircuit(final int[] A, final int[] B) {
        int availableGas = 0, i = 0;

        int totalGas = 0, totalCost = 0;
        for (int j = 0; j < A.length; j++) {
            totalCost += B[j];
            totalGas += A[j];
        }
        if (totalCost > totalGas) return -1;

        for (i = 0; i < B.length; i++) {
            if (A[i] < B[i]) continue;

            availableGas = A[i] - B[i];
            int j = (i + 1) % A.length;
            for (; j != i; j = (j + 1) % A.length) {
                if (availableGas + A[j] < B[j]) break;
                else {
                    availableGas += A[j];
                    availableGas -= B[j];
                }
            }
            if (j == i) return i;
        }
        return -1;
    }
}
