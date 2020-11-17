package Question450.Array;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UnionOfTwoArrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            Set<Integer> set = new HashSet<>();
            while (n > 0) {
                set.add(sc.nextInt());
                n--;
            }
            while (m > 0) {
                set.add(sc.nextInt());
                m--;
            }
            System.out.println(set.size());
            t--;
        }
    }
}
