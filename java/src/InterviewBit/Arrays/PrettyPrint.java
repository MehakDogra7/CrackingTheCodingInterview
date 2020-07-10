package InterviewBit.Arrays;

public class PrettyPrint {

    public static void main(String[] args) {

        int[][] result = new PrettyPrint().prettyPrint(3);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] prettyPrint(int A) {
        int n = (2 * A) - 1;
        int[][] result = new int[n][n];

        int top = 0, bottom = n - 1;   //row
        int left = 0, right = n - 1; //column
        while (A > 0) {

            for (int i = left; i <= right; i++) {
                result[top][i] = A;
                result[bottom][i] = A;
            }

            for (int i = top; i <= bottom; i++) {
                result[i][left] = A;
                result[i][right] = A;
            }

            top++;
            bottom--;
            left++;
            right--;

            A--;
        }

        return result;
    }

}
