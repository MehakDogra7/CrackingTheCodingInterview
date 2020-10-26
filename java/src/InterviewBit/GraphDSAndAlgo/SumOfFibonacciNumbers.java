package InterviewBit.GraphDSAndAlgo;

import java.util.ArrayList;

/**
 * Greedy Solution
 */
public class SumOfFibonacciNumbers {

    public static void main(String[] args) {
        System.out.println(new SumOfFibonacciNumbers().fibsum(4));
    }

    public int fibsum(int A) {

        ArrayList<Integer> fibonacci = calculateFibonacci(A);
        int count = 0, i = fibonacci.size() - 1;

        while (A > 0) {
            count += A / fibonacci.get(i);
            A %= fibonacci.get(i--);
        }

        return count;
    }

    private ArrayList<Integer> calculateFibonacci(int a) {
        ArrayList<Integer> fib = new ArrayList<>();

        int first = 0, second = 1, c = first + second;
        fib.add(second);

        while (c <= a) {
            fib.add(c);
            first = second;
            second = c;
            c = first + second;
        }
        return fib;
    }
}
