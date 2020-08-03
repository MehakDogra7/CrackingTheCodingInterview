package InterviewBit.HeapsAndMaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MagicianAndChocolates {

    public static void main(String[] args) {
        int A = 5;
        ArrayList<Integer> B = new ArrayList<>(List.of(2, 4, 6, 8, 10));
        System.out.println(new MagicianAndChocolates().solve(A, B));
    }

    private int solve(int A, ArrayList<Integer> B) {
        B.sort(Comparator.reverseOrder());
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        heap.addAll(B);

        long sum = 0;
        while (A > 0) {
            int num = heap.poll();
            sum += num;
            sum %= 1000000007;
            heap.add(num >> 1);
            A--;
        }

        return (int) sum;
    }
}
