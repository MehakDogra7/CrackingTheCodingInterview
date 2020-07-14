package InterviewBit.BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class PaintersPartitionProblem {

    public static void main(String[] args) {
        int A = 2;
        int B = 5;
        ArrayList<Integer> C = new ArrayList<>(List.of(1, 10));

        System.out.println(new PaintersPartitionProblem().paint(A, B, C));
    }

    public int paint(int A, int B, ArrayList<Integer> C) {
        long low = 0;
        long high = 0;
        long ans = 0;

        for (Integer i : C) {
            high += i;
        }

        while (low <= high) {
            long mid = low + (high - low) / 2;
            boolean isPossible = isPossible(A, mid, C);
            if (isPossible) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) ((ans * B) % 10000003);
    }

    private boolean isPossible(int A, long mid, ArrayList<Integer> C) {

        long sum = 0;
        int j = 0;
        for (int i = 0; i < C.size(); i++) {
            if (sum + C.get(i) <= mid) {
                sum += C.get(i);
            } else {
                j++;
                i--;
                sum = 0;
            }
            if (j >= A) {
                return false;
            }
        }

        return true;
    }
}
