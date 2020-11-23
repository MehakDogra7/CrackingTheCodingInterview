package Question450.Array;

public class MedianOf2SortedArraysOfDifferentSize {

    public static void main(String[] args) {
        int[] A = {3, 6, 8, 9};
        int[] B = {1, 2, 4, 5, 7};

        System.out.println(new MedianOf2SortedArraysOfDifferentSize().solve(A, B));
    }

    private double solve(int[] A, int[] B) {
        if (A.length > B.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        int m = A.length, n = B.length;

        int overAllMedian = (m + n + 1) / 2;
        int partitionX, partitionY;
        int start = 0, end = m;

        while (start <= end) {
            partitionX = (start + end) >> 1;
            partitionY = overAllMedian - partitionX;

            int leftX = partitionX == 0 ? Integer.MIN_VALUE : A[partitionX - 1];
            int rightX = partitionX == m ? Integer.MAX_VALUE : A[partitionX];

            int leftY = partitionY == 0 ? Integer.MIN_VALUE : B[partitionY - 1];
            int rightY = partitionY == n ? Integer.MAX_VALUE : B[partitionY];

            if (leftX <= rightY && leftY <= rightX) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(leftX, leftY) + Math.min(rightX, rightY)) / 2.0;
                }
                return Math.max(leftX, leftY);
            }

            if (leftX > rightY) {
                end = partitionX;
            } else {
                start = partitionX + 1;
            }

        }

        return 0;
    }
}
