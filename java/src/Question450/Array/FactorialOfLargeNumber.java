package Question450.Array;

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialOfLargeNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            System.out.println(fact(n));
            t--;
        }
    }

    private static BigInteger fact(int n) {
        BigInteger fact = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }
}
