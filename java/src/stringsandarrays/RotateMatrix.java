package stringsandarrays;

public class RotateMatrix {
    /**
     * Input matrix:                  Output matrix:
     * 1 2 3          Rotate          7 4 1
     * 4 5 6          ----->          8 5 2
     * 7 8 9          90 deg          9 6 3
     *
     * @param args
     */

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println("Input matrix:");
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        int[][] rotatedMatrix = rotateOutplace(matrix);
        System.out.println("Output matrix outPlace:");
        for (int[] ints : rotatedMatrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        rotatedMatrix = rotateInplace(matrix);
        System.out.println("Output matrix Inplace:");
        for (int[] ints : rotatedMatrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int[][] rotateInplace(int[][] matrix) {

        for (int layer = 0; layer < matrix.length / 2; layer++) {
            int first = layer;
            int last = matrix.length - layer - 1;

            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];

                //left -> top
                matrix[first][i] = matrix[last - offset][first];

                //bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                //right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                //top -> right
                matrix[i][last] = top;
            }
        }
        return matrix;
    }

    private static int[][] rotateOutplace(int[][] matrix) {

        int[][] rotatedMatrix = new int[matrix.length][matrix[0].length];

        for (int i1 = matrix.length - 1, j2 = 0; i1 >= 0; i1--, j2++) {
            for (int j1 = 0, i2 = 0; j1 < matrix[i1].length; j1++, i2++) {
                rotatedMatrix[i2][j2] = matrix[i1][j1];
            }

        }
        return rotatedMatrix;
    }
}
