package Question450.Matrix;

public class RowWithMax1s {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}};
        int n = 4, m = 4;
        System.out.println(new RowWithMax1s().rowWithMax1s(arr, n, m));
    }

    public int rowWithMax1s(int[][] arr, int n, int m) {
        // code here
        int expectedRow = 0;
        int expectedIndex = m;
        for (int i = 0; i < m; i++) {
            if (arr[0][i] == 1) {
                expectedIndex = i;
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < expectedIndex; j++) {
                if (arr[i][j] == 1) {
                    expectedIndex = j;
                    expectedRow = i;
                    break;
                }
            }
        }
        return expectedIndex == m ? -1 : expectedRow;
    }
}
