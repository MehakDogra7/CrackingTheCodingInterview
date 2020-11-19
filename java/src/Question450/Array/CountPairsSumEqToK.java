package Question450.Array;

import java.util.HashMap;
import java.util.Map;

public class CountPairsSumEqToK {

    public static void main(String[] args) {
        int[] A = {1, 5, 7, 1};
        System.out.println(new CountPairsSumEqToK().getPairsCount(A, A.length, 6));
    }

    int getPairsCount(int[] arr, int n, int k) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += map.getOrDefault(k - arr[i], 0);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return count;
    }
}
