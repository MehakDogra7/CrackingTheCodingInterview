package LeetCode.Contest;

import java.util.*;

public class MinHammingDistance {

    public static void main(String[] args) {
        int[] source = {1, 2, 3, 4};
        int[] target = {2, 1, 4, 5};
        int[][] allowedSwaps = {
                {0, 1},
                {2, 3}
        };
        System.out.println(new MinHammingDistance().minimumHammingDistance(source, target, allowedSwaps));
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {

        Set<AllowedSwap> allowedSwapSet = new HashSet<>();
        for (int[] allowedSwap : allowedSwaps) {
            allowedSwapSet.add(new AllowedSwap(allowedSwap[0], allowedSwap[1]));
        }

        Map<Integer, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            targetMap.put(target[i], i);
        }



        return 0;
    }

    static class AllowedSwap implements Comparable<AllowedSwap> {
        int a, b;

        public AllowedSwap(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(AllowedSwap allowedSwap) {
            if (allowedSwap.a == this.a) {
                return Integer.compare(this.b, allowedSwap.b);
            }
            return Integer.compare(this.a, allowedSwap.a);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AllowedSwap that = (AllowedSwap) o;
            return a == that.a && b == that.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
