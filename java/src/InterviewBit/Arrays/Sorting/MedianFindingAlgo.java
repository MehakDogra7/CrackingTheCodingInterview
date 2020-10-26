package InterviewBit.Arrays.Sorting;

import java.util.Arrays;

public class MedianFindingAlgo {

    public static void main(String[] args) {
        double[] A = {12, 3, 5, 7, 4, 19, 26};
        System.out.println(new MedianFindingAlgo().findMedian(A, 0, A.length - 1));

    }

    private double findMedian(double[] A, int low, int high) {

        int n = high - low + 1;
        int numberOfMedians = (n - 1) / 5 + 1;
        double[] median = new double[numberOfMedians];
        int i = 0;
        for (i = 0; i < n / 5; i++)
            median[i] = sortAndFindMedian(A, low + i * 5, low + i * 5 + 4);

        //for last
        if (n % 5 != 0) {
            median[i] = sortAndFindMedian(A, low + i * 5, low + i * 5 + n % 5 - 1);
            i++;
        }

        double overallMedian = -1;
        if (i == 1)
            overallMedian = median[0];
        else
            overallMedian = findMedian(median, 0, median.length - 1);

        return overallMedian;
    }

    private double sortAndFindMedian(double[] A, int start, int end) {
        Arrays.sort(A, start, end + 1);

        int n = end - start + 1;
        int mid = (end + start) / 2;

        return n % 2 != 0 ? A[mid] : (A[mid] + A[mid + 1]) / 2.0;
    }
}
