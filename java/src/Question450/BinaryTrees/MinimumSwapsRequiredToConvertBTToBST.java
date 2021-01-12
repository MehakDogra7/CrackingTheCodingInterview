package Question450.BinaryTrees;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumSwapsRequiredToConvertBTToBST {

    public static void main(String[] args) {
        int[] A = {5, 6, 7, 8, 9, 10, 11};
        System.out.println(new MinimumSwapsRequiredToConvertBTToBST().solve(A));
    }

    private int solve(int[] A) {

        ArrayList<Integer> inOrder = new ArrayList<>();
        generateInOrder(A, inOrder, 0);

        int[][] map = new int[A.length][2];
        for (int i = 0; i < inOrder.size(); i++) {
            map[i][0] = inOrder.get(i);
            map[i][1] = i;
        }

        Arrays.sort(map, (o1, o2) -> o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]));
        int ans = 0;
        boolean[] visited = new boolean[A.length];
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

    private void generateInOrder(int[] A, ArrayList<Integer> inOrder, int i) {
        if (i >= A.length) return;

        generateInOrder(A, inOrder, 2 * i + 1);
        inOrder.add(A[i]);
        generateInOrder(A, inOrder, 2 * i + 2);
    }
}
