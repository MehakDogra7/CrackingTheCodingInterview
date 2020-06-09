package InterviewBit.Arrays;

public class SpiralOrderMatrix2 {

    public static void main(String[] args) {
        int[][] result = spiralOrder(4);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] spiralOrder(int A) {
        final int[][] result = new int[A][A];

        int ASquare = A * A, temp = 1;
        int t = 0, b = A - 1, l = 0, r = A - 1;
        int dir = 0;

        while (t <= b && l <= r) {
            if (dir == 0) {
                for (int i = l; i <= r; i++) {
                    result[t][i] = temp++;
                }
                dir = 1;
                t++;
            } else if (dir == 1) {
                for (int i = t; i <= b; i++) {
                    result[i][r] = temp++;
                }
                dir = 2;
                r--;
            } else if (dir == 2) {
                for (int i = r; i >= l; i--) {
                    result[b][i] = temp++;
                }
                dir = 3;
                b--;
            } else if (dir == 3) {
                for (int i = b; i >= t; i--) {
                    result[i][l] = temp++;
                }
                dir = 0;
                l++;
            }
        }

        return result;
    }
}
