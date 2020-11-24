package Question450.Matrix;

public class SearchA2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5}
        };
        System.out.println(new SearchA2DMatrix().searchMatrix(matrix, 1));
    }

    public boolean searchMatrix(int[][] matrix, int target) { // m * n

        if (matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int lowRow = 0, highRow = m - 1;
        int lowColumn = 0, highColumn = n - 1;

        while (lowRow <= highRow && lowColumn <= highColumn) {
            int midRow = (lowRow + highRow) / 2;
            int midColumn = (lowColumn + highColumn) / 2;

            int mid = matrix[midRow][midColumn];
            if (mid == target) return true;

            else if (target > mid) {
                if (target > matrix[midRow][highColumn]) {
                    lowRow = midRow + 1;
                } else {
                    return binarySearch(matrix[midRow], midColumn, highColumn, target);
                }
            } else {
                if (target >= matrix[midRow][lowColumn]) {
                    return binarySearch(matrix[midRow], lowColumn, midColumn, target);
                } else {
                    highRow = midRow - 1;
                }
            }
        }

        return false;
    }

    private boolean binarySearch(int[] matrix, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid] == target) return true;
            else if (target > matrix[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
