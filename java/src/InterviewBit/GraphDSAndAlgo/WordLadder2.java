package InterviewBit.GraphDSAndAlgo;

import java.util.*;

public class WordLadder2 {

    public static void main(String[] args) {
        String A = "hit";
        String B = "cog";
        ArrayList<String> C = new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log", "cog"));
        ArrayList<ArrayList<String>> res = new WordLadder2().findLadders(A, B, C);
        res.forEach(list -> {
            list.forEach(s -> System.out.print(s + " "));
            System.out.println();
        });

    }

    public ArrayList<ArrayList<String>> findLadders(String A, String B, ArrayList<String> dict) {
        Set<String> C = new HashSet<>(dict);

        ArrayList<ArrayList<String>> res = new ArrayList<>();
        Map<String, Boolean> visited = new HashMap<>();
        for (String c : C) {
            visited.put(c, false);
        }

        Queue<QueueObject> queue = new ArrayDeque<>();
        ArrayList<String> temp = new ArrayList<>();
        temp.add(A);
        queue.add(new QueueObject(A, temp, visited));

        while (!queue.isEmpty()) {
            QueueObject curr = queue.poll();
            Map<String, Boolean> currVisited = curr.visited;
            if (curr.s.equals(B)) {
                if (res.size() == 0 || curr.strings.size() == res.get(0).size())
                    res.add(curr.strings);
                else {
                    return res;
                }
                continue;
            }
            for (String s : C) {
                if (currVisited.get(s)) continue;

                if (isDifferBy1(curr.s, s)) {
                    ArrayList<String> temp1 = new ArrayList<>(curr.strings);
                    temp1.add(s);
                    Map<String, Boolean> tempVisited = new HashMap<>(currVisited);
                    tempVisited.put(s, true);
                    queue.add(new QueueObject(s, temp1, tempVisited));
                }
            }
        }
        return res;
    }

    public boolean isDifferBy1(String A, String B) {

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) return A.substring(i + 1).equals(B.substring(i + 1));
        }

        return true;
    }

    static class QueueObject {
        String s;
        ArrayList<String> strings;
        Map<String, Boolean> visited;

        public QueueObject(String s, ArrayList<String> strings, Map<String, Boolean> visited) {
            this.s = s;
            this.strings = new ArrayList<>(strings);
            this.visited = new HashMap<>(visited);
        }
    }
}
