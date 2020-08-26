package InterviewBit.HeapsAndMaps;

import java.util.*;

public class LRUCache {

    Map<Integer, Integer> map;
    Queue<Integer> queue;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.queue = new ArrayDeque<>();
        this.capacity = capacity;
    }

    //S 2 6 G 1 S 1 5 S 1 2 G 1 G 2
    public static void main(String[] args) {
        LRUCache LRUCache = new LRUCache(7);
        String input = "S 2 1 S 1 10 S 8 13 G 12 S 2 8 G 11 G 7 S 14 7 S 12 9 S 7 10 G 11 S 9 3 S 14 15 G 15 G 9 S 4 13 G 3 S 13 7 G 2 S 5 9 G 6 G 13 S 4 5 S 3 2 S 4 12 G 13 G 7 S 9 7 G 3 G 6 G 2 S 8 4 S 8 9 S 1 4 S 2 9 S 8 8 G 13 G 3 G 13 G 6 S 3 8 G 14 G 4 S 5 6 S 10 15 G 12 S 13 5 S 10 9 S 3 12 S 14 15 G 4 S 10 5 G 5 G 15 S 7 6 G 1 S 5 12 S 1 6 S 11 8";
        String[] s = input.split(" ");
        for (int i = 0; i < s.length; ) {
            if (s[i].equals("S")) {
                int key = Integer.parseInt(s[i + 1]);
                int value = Integer.parseInt(s[i + 2]);
                LRUCache.set(key, value);
                i = i + 3;
            } else {
                int key = Integer.parseInt(s[i + 1]);
                System.out.print(LRUCache.get(key) + " ");
                i = i + 2;
            }
        }
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            queue.remove(key);
            queue.add(key);
            return map.get(key);
        } else return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            queue.remove(key);
        } else {
            if (map.size() == capacity) {
                map.remove(queue.poll());
            }
            map.put(key, value);
        }
        queue.add(key);
    }
}
