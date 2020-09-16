package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class LeadersInAnArray {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(16, 17, 4, 3, 5, 2));
        new LeadersInAnArray().solve(A).forEach(i -> System.out.print(i + " "));
    }

    private ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        if (n == 0) return new ArrayList<>();
        if (n == 1) return A;

        ArrayList<Integer> result = new ArrayList<>();
        result.add(A.get(n - 1));
        int maxTillNow = A.get(n - 1);

        for (int i = n - 2; i > -1; i--) {
            if (A.get(i) > maxTillNow) result.add(A.get(i));
            maxTillNow = Integer.max(maxTillNow, A.get(i));
        }

        return result;
    }
}
