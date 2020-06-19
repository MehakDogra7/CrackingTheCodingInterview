package InterviewBit.Math;

import java.util.ArrayList;

public class PrimeSum {

    public static void main(String[] args) {
        new PrimeSum().primesum(4).forEach(i -> System.out.print(i + " "));
    }

    public ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 2; i < A; i++) {
            if (isPrime(i) && isPrime(A - i)) {
                result.add(i);
                result.add(A - i);
                return result;
            }
        }

        return result;
    }

    public boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
