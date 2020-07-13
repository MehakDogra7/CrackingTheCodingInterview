package InterviewBit.BinarySearch;

import java.util.List;

public class MedianOfTwoSortedArray {

    public static void main(String[] args) {
        List<Integer> B = List.of(-34, -18, -12, -3, 12, 16, 20, 31, 44);
        List<Integer> A = List.of(-27, 25, 38);

        /*List<Integer> A = List.of(23, 26, 31, 35);
        List<Integer> B = List.of(3, 5, 7, 9, 11, 16);*/

        /*List<Integer> A = List.of(1, 3, 8, 9, 15);
        List<Integer> B = List.of(7, 11, 18, 19, 21, 25);*/

        System.out.println(new MedianOfTwoSortedArray().findMedianSortedArrays(A, B));
    }

    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

        int bSize = b.size();
        int aSize = a.size();

        //Handle Zero
        if (aSize == 0 || bSize == 0) {
            if (aSize == 0) {
                return getMedian(b);
            } else {
                return getMedian(a);
            }
        }

        //Handle One
        else if (aSize == 1 || bSize == 1) {
            if (aSize == 1) {
                return handle1SizeCase(b, a.get(0));
            } else {
                return handle1SizeCase(a, b.get(0));
            }
        }

        if (a.size() < b.size()) {
            return findMedianSortedArraysUtility(a, b);
        }
        return findMedianSortedArraysUtility(b, a);
    }

    public double findMedianSortedArraysUtility(final List<Integer> smaller, final List<Integer> larger) {

        int x = smaller.size();
        int y = larger.size();
        int partitionSum = (x + y + 1) / 2;

        int low = 0;
        int high = x;
        int leftX = 0, rightX = 0, leftY = 0, rightY = 0;
        int partitionX = low + (high - low) / 2;
        int partitionY = partitionSum - partitionX;

        while (partitionX != 0 && partitionX != x) {

            partitionX = low + (high - low) / 2;
            partitionY = partitionSum - partitionX;

            leftX = partitionX != 0 ? smaller.get(partitionX - 1) : Integer.MIN_VALUE;
            rightX = partitionX != x ? smaller.get(partitionX) : Integer.MAX_VALUE;
            leftY = larger.get(partitionY - 1);
            rightY = larger.get(partitionY);

            if (leftX <= rightY && leftY <= rightX) {
                break;
            } else if (leftX > rightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }

        }

        if (((x + y) & 1) == 1) {
            return Integer.max(leftX, leftY);
        } else {
            return getMedianOf4Size(leftX, leftY, rightX, rightY);
        }
    }

    public double getMedianOf4Size(int a, int b, int c, int d) {
        int min = Integer.min(Integer.min(Integer.min(a, b), c), d);
        int max = Integer.max(Integer.max(Integer.max(a, b), c), d);
        return (a + b + c + d - min - max) / 2.0;
    }

    public double getMedian(List<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }
        int mid = list.size() / 2;
        if ((list.size() & 1) == 1) {
            return list.get(mid);
        } else {
            return (list.get(mid) + list.get(mid - 1)) / 2.0;
        }
    }

    public double handle1SizeCase(List<Integer> list, int x) {
        if (list.size() == 1) {
            return (list.get(0) + x) / 2.0;
        }
        int midIndex = list.size() / 2;
        if ((list.size() & 1) == 1) {
            return getMedianOf4Size(list.get(midIndex - 1), list.get(midIndex), list.get(midIndex + 1), x);
        }
        return getMedianOf3Size(list.get(midIndex - 1), list.get(midIndex), x);
    }

    public double getMedianOf3Size(int a, int b, int c) {
        int min = Integer.min(Integer.min(a, b), c);
        int max = Integer.max(Integer.max(a, b), c);
        return (a + b + c - min - max);
    }
}
