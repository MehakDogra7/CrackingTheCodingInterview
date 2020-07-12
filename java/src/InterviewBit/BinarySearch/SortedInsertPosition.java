package InterviewBit.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedInsertPosition {

    public static void main(String[] args) {

        Integer[] A = {1, 3, 5, 6};
        int B = 2;
        System.out.println(new SortedInsertPosition().searchInsert(new ArrayList<>(Arrays.asList(A)), B));

    }

    public int searchInsert(ArrayList<Integer> a, int b) {

        int low = 0;
        int high = a.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a.get(mid) == b) {
                return mid;
            } else if (a.get(mid) < b) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
