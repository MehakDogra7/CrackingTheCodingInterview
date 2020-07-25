package InterviewBit.StacksAndQueues;

import java.util.*;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        System.out.println(new FirstNonRepeatingCharacter().solve("abba"));
        System.out.println(new FirstNonRepeatingCharacter().solve1("abba"));
    }

    public String solve(String A) {
        if (A.length() == 0)
            return "#";

        if (A.length() == 1)
            return A;

        StringBuilder B = new StringBuilder(String.valueOf(A.charAt(0)));
        ArrayList<Character> queue = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        boolean[] flag = new boolean[26];

        queue.add(A.charAt(0));
        set.add(A.charAt(0));

        for (int i = 1; i < A.length(); i++) {
            char curr = A.charAt(i);
            if (!queue.isEmpty() && curr != queue.get(0)) {
                B.append(queue.get(0));
                int index = A.charAt(i) - 97;
                if (!set.contains(A.charAt(i))) {
                    queue.add(A.charAt(i));
                    set.add(A.charAt(i));
                    flag[index] = true;
                } else {
                    if (flag[index]) {
                        queue.remove((Character) A.charAt(i));
                        flag[index] = false;
                    }
                }
            } else if (queue.isEmpty()) {
                if (!set.contains(A.charAt(i))) {
                    queue.add(A.charAt(i));
                    set.add(A.charAt(i));
                    B.append(A.charAt(i));
                } else {
                    B.append('#');
                }
            } else {
                while (!queue.isEmpty() && curr == queue.get(0)) {
                    queue.remove(0);
                }
                if (queue.isEmpty()) {
                    B.append('#');
                } else {
                    B.append(queue.get(0));
                }
            }

        }

        return B.toString();
    }

    public String solve1(String A) {
        if (A.length() == 0)
            return "#";

        if (A.length() == 1)
            return A;

        StringBuilder B = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        int[] count = new int[26];

        for (int i = 0; i < A.length(); i++) {
            char curr = A.charAt(i);
            queue.add(curr);
            count[curr - 97]++;
            while (!queue.isEmpty() && count[queue.peek() - 97] > 1) {
                queue.remove();
            }
            if (queue.isEmpty()) {
                B.append('#');
            } else {
                B.append(queue.peek());
            }
        }

        return B.toString();
    }


}
