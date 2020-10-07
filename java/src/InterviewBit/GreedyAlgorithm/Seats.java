package InterviewBit.GreedyAlgorithm;

import java.util.ArrayList;

public class Seats {

    public static void main(String[] args) {
        String A = "....x..xx...x..";
        System.out.println(new Seats().solve(A));
    }

    private int solve(String A) {
        int mod = 10000003, n = A.length();
        ArrayList<Integer> seats = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (A.charAt(i) == 'x')
                seats.add(i);

        int median = seats.size() / 2;
        long ans = 0;

        for (int i = 0; i < seats.size(); i++) {
            int curr = seats.get(i);
            int dest = seats.get(median) - (median - i);
            ans = (ans + Math.abs(dest - curr)) % mod;
        }

        return (int) ans;
    }
}
