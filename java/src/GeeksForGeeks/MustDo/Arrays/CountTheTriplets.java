package GeeksForGeeks.MustDo.Arrays;

import java.util.HashMap;
import java.util.Map;

public class CountTheTriplets {
    public static void main(String[] args) {
        int[] A = {1, 5, 3, 2};
        solve(A);

    }

    public static void solve(int[] A) {
        if (A.length < 3) {
            System.out.println(-1);
            return;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int n = A.length, count = 0;

        for (int i = 0; i < n; i++) {
            map.put(A[i], i);
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (map.containsKey(A[i] + A[j])) {
                    int index = map.get(A[i] + A[j]);
                    if (index != i && index != j) count++;
                }
            }
        }
        if (count == 0)
            System.out.println(-1);
        else
            System.out.println(count);
    }
}
