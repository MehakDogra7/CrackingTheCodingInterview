package CompaniesInterviewExperience.Walmart;

import java.util.ArrayList;

/**
 * https://www.geeksforgeeks.org/minimum-jumps-required-to-make-a-group-of-persons-sit-together/
 */
public class MinJumps {

    public static void main(String[] args) {
        String A = "xxx........xxxxxx";
        System.out.println(solve(A));
    }

    private static int solve(String A) {
        int mod = 1000000009, count = 0;
        ArrayList<Integer> listOfIndices = new ArrayList<>();

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'x') listOfIndices.add(i);
        }

        int median = listOfIndices.size() / 2;

        for (int i = 0; i < listOfIndices.size(); i++) {
            int curr = listOfIndices.get(i);
            int dest = listOfIndices.get(median) - (median - i);
            int diff = Math.abs(dest - curr);
            count = (count % mod + diff % mod) % mod;
        }

        return count;
    }
}
