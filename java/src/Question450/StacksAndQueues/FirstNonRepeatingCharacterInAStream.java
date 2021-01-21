package Question450.StacksAndQueues;

import java.util.ArrayDeque;

public class FirstNonRepeatingCharacterInAStream {

    public static void main(String[] args) {
        String A = "aabc";
        System.out.println(new FirstNonRepeatingCharacterInAStream().FirstNonRepeating(A));
    }

    public String FirstNonRepeating(String A) {
        // code here
        StringBuilder res = new StringBuilder("");
        int[] charCount = new int[26];
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < A.length(); i++) {
            char curr = A.charAt(i);
            charCount[curr - 97]++;
            if (charCount[curr - 97] == 1) {
                queue.add(curr);
            }
            while (!queue.isEmpty() && charCount[queue.peek() - 97] > 1) queue.pollFirst();
            res.append(queue.isEmpty() ? '#' : queue.peek());
        }

        return res.toString();
    }
}
