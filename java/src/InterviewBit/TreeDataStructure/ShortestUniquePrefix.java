package InterviewBit.TreeDataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestUniquePrefix {
    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>(List.of("zebra", "dog", "duck", "dove"));
        new ShortestUniquePrefix().prefix(A).forEach(i -> System.out.print(i + " "));
    }

    public ArrayList<String> prefix(ArrayList<String> A) {
        ArrayList<String> result = new ArrayList<>();
        Trie trie = new Trie();
        for (String str : A) {
            trie.insert(str);
        }
        for (String str : A) {
            result.add(trie.getShortestPrefix(str));
        }
        return result;
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

        public String getShortestPrefix(String word) {
            TrieNode currNode = root;
            int lastIndex = 0;

            for (int i = 0; i < word.length(); i++) {
                char currChar = word.charAt(i);
                TrieNode next = currNode.children.get(currChar);
                if (next.children.size() > 1) lastIndex = i + 1;
                currNode = next;
            }
            return word.substring(0, lastIndex + 1);
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
