package InterviewBit.BinarySearch;

public class MatrixSearch {

    public static void main(String[] args) {

        int[][] A = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        int B = 5;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.println(new MatrixSearch().search(A, A[i][j] + 1));
            }
        }

    }

    private int search(int[][] A, int B) {

        int n = A.length - 1;           //# of Rows
        int m = A[0].length - 1;        //# of Columns
        int lowR = 0, highR = n;
        int lowC = 0, highC = m;

        while (lowR <= highR && lowC <= highC) {
            int midR = lowR + (highR - lowR) / 2;
            int midC = lowC + (highC - lowC) / 2;

            int midValue = A[midR][midC];
            if (midValue == B) {
                return 1;
            } else if (midValue < B) {
                if (A[midR][m] >= B) {
                    lowC = midC + 1;
                } else {
                    lowR = midR + 1;
                }
            } else {
                if (A[midR][0] <= B) {
                    highC = midC - 1;
                } else {
                    highR = midR - 1;
                }
            }
        }

        return 0;
    }


}
