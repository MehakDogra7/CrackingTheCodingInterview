public class ZeroMatrix {

    /**
     * Input matrix:                  Output matrix:
     * 1  0  3  4         Nullify      0  0  0  0
     * 5  6  7  8        ----->        5  0  7  8
     * 9  10 11 12        make zero    9  0  11 12
     *
     * @param args
     */

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 0, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        makeZero(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private static void makeZero(int[][] matrix) {

        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;

        //check 1st row for any zero
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
            }
        }
        //check 1st column for any zero
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColumnHasZero = true;
            }
        }
        //check for remaining rows and columns
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //NullifyRow based on first column
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                nullifyRow(matrix, i);
            }
        }
        //NullifyColumn based on first row
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                nullifyColumn(matrix, j);
            }
        }
        //nullify first row and column if required
        if (firstRowHasZero) {
            nullifyRow(matrix, 0);
        }
        if (firstColumnHasZero) {
            nullifyColumn(matrix, 0);
        }
    }

    private static void nullifyRow(int[][] matrix, int i) {
        for (int j = 0; j < matrix[i].length; j++) {
            matrix[i][j] = 0;
        }
    }

    private static void nullifyColumn(int[][] matrix, int j) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][j] = 0;
        }
    }
}
