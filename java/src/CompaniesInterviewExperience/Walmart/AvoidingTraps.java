package CompaniesInterviewExperience.Walmart;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AvoidingTraps {

    public static void main(String[] args) {
        int r1 = 2, r2 = 3, N = 11;
        String s = "#*#*#*#*#*#";
        System.out.println(trap_sol(r1, r2, N, s));
    }

    static String trap_sol(int r1, int r2, int N, String s) {
        // Write your code here
        if ((N != 1 && s.charAt(0) == '*') || s.charAt(N - 1) == '*') return "No way!";
        if (N == 1) return "0";

        String res = "";
        boolean[] primes = findPrimes(N);

        int[] primeCount = new int[N + 1];
        int countTillNow = 0;
        for (int i = 2; i < N + 1; i++) {
            if (primes[i]) countTillNow++;
            primeCount[i] = countTillNow;
        }

        Set<Integer> primeJump = new HashSet<>();
        for (int i = 1; i < primeCount.length; i++) {
            int A = primeCount[i];
            if ((A * r2) >= (i * r1)) {
                primeJump.add(i);
            }
        }

        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[N] = 0;
        for (int i = N - 1; i >= 1; i--) {
            if (s.charAt(i - 1) == '#') {
                int x = dp[i + 1] == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1 + dp[i + 1];
                int y = i + 2 <= N && dp[i + 2] != Integer.MAX_VALUE ? 1 + dp[i + 2] : Integer.MAX_VALUE;
                int z = primeJump.contains(i) && i + primeCount[i] <= N && dp[i + primeCount[i]] != Integer.MAX_VALUE ? 1 + dp[i + primeCount[i]] : Integer.MAX_VALUE;

                dp[i] = Math.min(x, Math.min(y, z));
            }
        }

        for (int i = 1; i < dp.length; i++) {
            System.out.println(i + ": " + dp[i]);
        }

        System.out.println();

        return dp[1] == Integer.MAX_VALUE ? "No way!" : String.valueOf(dp[1]);
    }

    private static boolean[] findPrimes(int N) {
        boolean[] primes = new boolean[N + 1];              //True means prime
        Arrays.fill(primes, true);

        primes[0] = false;
        primes[1] = false;
        for (int p = 2; p < N + 1; p++) {
            if (primes[p]) {
                for (int i = p * p; i < N + 1 && i > 1; i += p) {
                    primes[i] = false;
                }
            }
        }

        return primes;
    }
}
