package InterviewBit.GraphDSAndAlgo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class WordLadder1 {

    public static void main(String[] args) {
        String A = "hit";
        String B = "cog";
        ArrayList<String> C = new ArrayList<>(List.of("hot", "dot", "dog", "lot", "cog"));
        System.out.println(new WordLadder1().solve(A, B, C));
    }

    public int solve(String A, String B, ArrayList<String> C) {
        if (A.equals(B)) return 1;
        Queue<QueueObject> queue = new ArrayDeque<>();
        queue.add(new QueueObject(A, 0));

        while (!queue.isEmpty()) {
            QueueObject curr = queue.poll();
            if (curr.s.equals(B)) return curr.count + 1;
            for (int i = 0; i < C.size(); i++) {
                String s = C.get(i);
                if (isDifferBy1(curr.s, s)) {
                    queue.add(new QueueObject(s, curr.count + 1));
                    C.remove(s);
                    i--;
                }

            }
        }


        return 0;
    }

    public boolean isDifferBy1(String A, String B) {

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) return A.substring(i + 1).equals(B.substring(i + 1));
        }

        return true;
    }

    static class QueueObject {
        String s;
        int count;

        public QueueObject(String s, int count) {
            this.s = s;
            this.count = count;
        }
    }
}
