package InterviewBit.TreeDataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelReviews {

    public static void main(String[] args) {
        String A = "cool_ice_wifi";
        ArrayList<String> B = new ArrayList<>(List.of("water_is_cool", "cold_ice_drink", "cool_wifi_speed"));
        new HotelReviews().solve(A, B).forEach(i -> System.out.print(i + " "));
    }

    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<StringObject> temp = new ArrayList<>();
        Trie trie = new Trie();

        String[] aArray = A.split("_");
        for (String goodWord : aArray) {
            trie.insert(goodWord);
        }

        for (int i = 0, bSize = B.size(); i < bSize; i++) {
            String review = B.get(i);
            int score = 0;
            String[] reviewArray = review.split("_");
            for (String reviewWord : reviewArray) {
                if (trie.search(reviewWord)) score++;
            }
            temp.add(new StringObject(i, score));
        }

        temp.sort(StringObject::compareTo);

        for (StringObject stringObject : temp) {
            result.add(stringObject.index);
        }
        return result;
    }

    public static class StringObject implements Comparable<StringObject> {
        Integer index;
        Integer score;

        public StringObject(Integer index, Integer score) {
            this.index = index;
            this.score = score;
        }

        @Override
        public int compareTo(StringObject o) {
            return Integer.compare(o.score, this.score);
        }
    }

    public static class Trie {
        public final TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode currNode = root;

            for (int i = 0; i < word.length(); i++) {
                char currChar = word.charAt(i);
                TrieNode next = currNode.children.get(currChar);
                if (next == null) {
                    next = new TrieNode();
                    currNode.children.put(currChar, next);
                }
                currNode = next;
            }
            currNode.endOfWord = true;
        }

        public boolean search(String word) {
            TrieNode currNode = root;

            for (int i = 0; i < word.length(); i++) {
                char currChar = word.charAt(i);
                TrieNode next = currNode.children.get(currChar);
                if (next == null) return false;
                currNode = next;
            }
            return currNode.endOfWord;
        }
    }

    public static class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }
}
