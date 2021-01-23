package InterviewBit.StacksAndQueues;

import java.util.*;

public class PrimeCalculations {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(10, 2, 1, 1, 2));
        System.out.println(new PrimeCalculations().solve(A, 3));
    }

    public int solve(ArrayList<Integer> A, int B) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> primeNumbers = generateAllPrimes(Collections.max(A));
        Map<Integer, Integer> distinctPrimeNumbers = new HashMap<>();

        long ans = 0;
        int mod = 1000000007;

        for (int i = 0; i < A.size(); i++) {
            int count = 0;
            int curr = A.get(i);
            if (!distinctPrimeNumbers.containsKey(curr)) {
                for (int j = 0; j < primeNumbers.size(); j++) {
                    if (curr % primeNumbers.get(j) == 0) count++;
                }
                distinctPrimeNumbers.put(curr, count);
            }
        }

        for (int i = 0; i < B; i++) {
            int currDistinctPrimeCount = distinctPrimeNumbers.get(A.get(i));
            while (!queue.isEmpty() && distinctPrimeNumbers.get(A.get(queue.peekLast())) < currDistinctPrimeCount)
                queue.pollLast();
            queue.addLast(i);
        }

        for (int i = B; i < A.size(); i++) {
            ans = (ans + A.get(queue.peekFirst())) % mod;
            if (queue.peekFirst() <= i - B) queue.pollFirst();
            int currDistinctPrimeCount = distinctPrimeNumbers.get(A.get(i));
            while (!queue.isEmpty() && distinctPrimeNumbers.get(A.get(queue.peekLast())) < currDistinctPrimeCount)
                queue.pollLast();
            queue.addLast(i);
        }

        ans = (ans + A.get(queue.peekFirst())) % mod;

        return (int) (ans % mod);
    }

    public ArrayList<Integer> generateAllPrimes(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) primes.add(0);

        int p = 2;
        while (p * p <= n) {
            if (primes.get(p) == 0) {
                for (int i = 2 * p; i < n + 1; i += p) {
                    primes.set(i, 1);
                }
            }
            p++;
        }
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i < n + 1; i++) {
            if (primes.get(i) == 0) primeNumbers.add(i);
        }
        return primeNumbers;
    }
}
