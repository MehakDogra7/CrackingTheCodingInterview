package Question450.Matrix;

import java.util.ArrayList;

public class SpirallyTraversingAMatrix {

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        ArrayList<Integer> list = spirallyTraverse(A, A.length, A[0].length);
        list.forEach(i -> System.out.print(i + " "));
    }

    static ArrayList<Integer> spirallyTraverse(int[][] matrix, int r, int c) {
        // code here
        int top = 0, bottom = r - 1, left = 0, right = c - 1;
        int direction = 0;
        ArrayList<Integer> res = new ArrayList<>();

        while (top <= bottom && left <= right) {
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
                top++;
                direction = 1;
            } else if (direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
                direction = 2;
            } else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
                direction = 3;
            } else {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
                direction = 0;
            }
        }
        return res;
    }
}
