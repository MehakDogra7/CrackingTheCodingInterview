package InterviewBit.GraphDSAndAlgo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class PossibilityOfFinishingCourses {

    public static void main(String[] args) {
        int A = 4;
        int[] B = {1, 2, 3, 4};
        int[] C = {2, 3, 4, 2};

        System.out.println(new PossibilityOfFinishingCourses().solve(A, B, C));
    }

    public int solve(int A, int[] B, int[] C) {
        int[] visited = new int[A + 1];
        Arrays.fill(visited, 0);
        for (int course : C)
            visited[course]++;

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i = 0; i < B.length; i++) {
                int prerequisite = B[i];
                if (prerequisite == curr) {
                    visited[C[i]]--;
                    if (visited[C[i]] == 0)
                        queue.add(C[i]);
                }
            }
        }
        for (int i = 1; i < visited.length; i++) {
            if (visited[i] != 0) return 0;

        }
        return 1;
    }
}
