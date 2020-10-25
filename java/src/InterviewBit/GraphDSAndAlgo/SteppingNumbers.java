package InterviewBit.GraphDSAndAlgo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class SteppingNumbers {

    ArrayList<Integer> result;

    public static void main(String[] args) {
        ArrayList<Integer> res = new SteppingNumbers().stepnum(10, 20);
        res.forEach(i -> System.out.print(i + " "));
    }

    public ArrayList<Integer> stepnum(int A, int B) {
        result = new ArrayList<>();

        for (int i = 0; i <= 9; i++) {
            bfs(A, B, i);
        }
        result.sort(Integer::compareTo);
        return result;
    }

    private void bfs(int A, int B, int U) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(U);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr >= A && curr <= B) {
                result.add(curr);
            }
            if (curr == 0 || curr > B) continue;

            if (curr % 10 != 0) queue.add(curr * 10 + (curr % 10) - 1);
            if (curr % 10 != 9) queue.add(curr * 10 + (curr % 10) + 1);
        }
    }
}
