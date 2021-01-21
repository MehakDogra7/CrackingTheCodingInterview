package Question450.StacksAndQueues;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxSumOfSquaresOfCharactersAfterKRemoval {

    public static void main(String[] args) {
        String s = "abccc";
        int k = 1;
        System.out.println(minValue(s, k));
    }

    static int minValue(String s, int k) {
        // code here
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<Pair>();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            priorityQueue.add(new Pair(entry.getValue(), entry.getKey()));
        }

        while (k > 0 && !priorityQueue.isEmpty()) {
            Pair poll = priorityQueue.poll();
            poll.count--;
            if (poll.count > 0) priorityQueue.add(poll);
            k--;
        }

        for (Pair pair : priorityQueue) {
            ans += pair.count * pair.count;
        }

        return ans;
    }

    static class Pair implements Comparable<Pair> {
        int count;
        char character;

        public Pair(int count, char character) {
            this.count = count;
            this.character = character;
        }

        @Override
        public int compareTo(Pair p) {
            return Integer.compare(p.count, this.count);
        }
    }
}
