package IIITCodingClub;

import java.util.HashSet;
import java.util.Set;

public class Pairs {

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2};
        int k = 2;
        System.out.println(pairs(k, arr));
    }

    static int pairs(int k, int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            if (set.contains(curr - k)) count++;
        }
        return count;
    }
}
