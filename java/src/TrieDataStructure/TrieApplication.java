package TrieDataStructure;

public class TrieApplication {

    public static void main(String[] args) {
        iterativeApplication();
        recursiveApplication();
    }

    private static void iterativeApplication() {
        Trie trie = new Trie();
        trie.insertIterative("abc");
        trie.insertIterative("abgl");
        trie.insertIterative("cdf");
        trie.insertIterative("abcd");
        trie.insertIterative("lmn");

        System.out.println(trie.searchIterative("abc")); //true
        System.out.println(trie.searchIterative("abbc")); //false
        System.out.println(trie.searchIterative("abcd")); //true
        System.out.println(trie.searchIterative("lmn")); //true
        System.out.println(trie.searchIterative("lmno")); //false

        System.out.println();
        trie.deleteRecursive("abc");
        System.out.println(trie.searchIterative("abc")); //false
        System.out.println(trie.searchIterative("abcd")); //true
        System.out.println();
    }

    private static void recursiveApplication() {
        Trie trie = new Trie();
        trie.insertRecursive("abc");
        trie.insertRecursive("abgl");
        trie.insertRecursive("cdf");
        trie.insertRecursive("abcd");
        trie.insertRecursive("lmn");

        System.out.println(trie.searchRecursive("abc")); //true
        System.out.println(trie.searchRecursive("abbc")); //false
        System.out.println(trie.searchRecursive("abcd")); //true
        System.out.println(trie.searchRecursive("lmn")); //true
        System.out.println(trie.searchRecursive("lmno")); //false

        System.out.println();
        trie.deleteRecursive("abc");
        System.out.println(trie.searchRecursive("abc")); //false
        System.out.println(trie.searchRecursive("abcd")); //true
        System.out.println();
    }
}
