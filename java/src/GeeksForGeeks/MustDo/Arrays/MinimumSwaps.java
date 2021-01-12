package GeeksForGeeks.MustDo.Arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Not necessarily adjacent
 */
public class MinimumSwaps {

    public static void main(String[] args) {
        int[] A = {8, 6, 9, 5, 10, 7, 11};
        System.out.println(new MinimumSwaps().solve(A));
    }

    /**
     * TC: O(nlogn)
     * SC: O(n)
     *
     * @param A
     * @return
     */
    private int solve(int[] A) {
        int[][] map = new int[A.length][2];

        for (int i = 0; i < A.length; i++) {
            map[i][0] = A[i];
            map[i][1] = i;
        }

        Arrays.sort(map, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));

        boolean[] visited = new boolean[A.length];
        Arrays.fill(visited, false);
        int ans = 0;

        for (int i = 0; i < A.length; i++) {
            if (visited[i] || map[i][1] == i) continue;
            int cycles = 0, j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = map[j][1];
                cycles++;
            }
            if (cycles > 0) ans += cycles - 1;
        }

        return ans;
    }
}
