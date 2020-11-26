package Question450.Matrix;

public class MedianRowWiseSortedMatrix {

    public static void main(String[] args) {
        int R = 3, C = 3;
        int[][] matrix = {
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        };

        System.out.println(new MedianRowWiseSortedMatrix().median(matrix, R, C));
    }

    public int median(int[][] matrix, int r, int c) {    // r * c
        // code here
        int desired = (r * c + 1) / 2;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < r; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][c - 1]);
        }

        while (low < high) {
            int mid = (low + high) / 2;
            int place = 0;

            for (int i = 0; i < r; i++) {
                int index = binarySearch(matrix[i], mid);
                if (index < 0) index = Math.abs(index);
                else {
                    while (index < matrix[i].length && matrix[i][index] == mid) index++;
                }
                place += index;
            }
            if (place < desired) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    private int binarySearch(int[] matrix, int target) {

        int low = 0, high = matrix.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid] == target) return mid;
            else if (target > matrix[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return -(low);
    }
}
