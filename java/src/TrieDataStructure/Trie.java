package TrieDataStructure;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    public final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    /**
     * Iterative implementation of insert into trie
     */
    public void insertIterative(String word) {
        TrieNode currNode = root;

        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            TrieNode next = currNode.children.get(currChar);
            //If node doesn't exits in the map then create one and put it into the map
            if (next == null) {
                next = new TrieNode();
                currNode.children.put(currChar, next);
            }
            currNode = next;
        }
        //mark the current nodes endOfWord as true... this would be the last node
        currNode.endOfWord = true;
    }

    /**
     * Recursive implementation of insert into trie
     */
    public void insertRecursive(String word) {
        insertRecursive(root, word, 0);
    }

    private void insertRecursive(TrieNode currNode, String word, int index) {
        //If we reached at end of the word then mark endOfWord as true... this would be the last node
        if (index == word.length()) {
            currNode.endOfWord = true;
            return;
        }

        char currChar = word.charAt(index);
        TrieNode next = currNode.children.get(currChar);

        //If node doesn't exits in the map then create one and put it into the map
        if (next == null) {
            next = new TrieNode();
            currNode.children.put(currChar, next);
        }
        insertRecursive(next, word, index + 1);
    }

    /**
     * Iterative implementation to search inside trie
     */
    public boolean searchIterative(String word) {
        TrieNode currNode = root;

        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            TrieNode next = currNode.children.get(currChar);
            //If next is null then it means that map doesn't contain entry of the char meaning search word doesn't exits so return false.
            if (next == null) return false;
            currNode = next;
        }
        //If we reached at the end of the searched word then check for currNode's endOfWord if true then it means that word exits otherwise not.
        return currNode.endOfWord;
    }

    /**
     * Recursive implementation to search inside trie
     */
    public boolean searchRecursive(String word) {
        return searchRecursive(root, word, 0);
    }

    private boolean searchRecursive(TrieNode currNode, String word, int index) {
        //If we reached at the end of the searched word then check for currNode's endOfWord if true then it means that word exits otherwise not.
        if (index == word.length()) return currNode.endOfWord;

        TrieNode nextNode = currNode.children.get(word.charAt(index));
        //If next is null then it means that map doesn't contain entry of the char meaning search word doesn't exits so return false.
        if (nextNode == null) return false;
        return searchRecursive(nextNode, word, index + 1);
    }

    /**
     * Recursive implementation to delete a word from trie
     * Returns true if word exits and false if doesn't exits.
     */
    public boolean deleteRecursive(String word) {
        return deleteRecursive(root, word, 0);
    }

    private boolean deleteRecursive(TrieNode currNode, String word, int index) {
        if (index == word.length()) {
            //If endOfWord is false then it means that word doesn't exists.
            if (!currNode.endOfWord) return false;
            currNode.endOfWord = false;
            //If current has no other mapping then return true meaning this node is eligible for deletion.
            return currNode.children.size() == 0;
        }

        char currChar = word.charAt(index);
        TrieNode next = currNode.children.get(currChar);
        if (next == null) return false;
        boolean isEligibleForDeletion = deleteRecursive(next, word, index + 1);
        //If true then delete the mapping of character and trieNode reference from map.
        if (isEligibleForDeletion) currNode.children.remove(currChar);
        return currNode.children.size() == 0;
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
