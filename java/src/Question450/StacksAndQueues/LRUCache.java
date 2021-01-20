package Question450.StacksAndQueues;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    static LinkedHashMap<Integer, Integer> cacheMap;

    LRUCache(int cap) {
        // Initialize the cache capacity with the given
        // cap
        cacheMap = new LinkedHashMap<Integer, Integer>(cap, 100.0f, true) {
            @Override
            public boolean removeEldestEntry(Map.Entry eldest) {
                return this.size() > cap;
            }
        };
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        set(1, 2);
        System.out.println(get(1));
    }

    // This method works in O(1)
    public static int get(int key) {
        // your code here
        return cacheMap.getOrDefault(key, -1);
    }

    // This method works in O(1)
    public static void set(int key, int value) {
        // your code here
        cacheMap.put(key, value);
    }
}
