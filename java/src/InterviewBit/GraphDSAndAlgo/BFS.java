package InterviewBit.GraphDSAndAlgo;

import java.util.*;

public class BFS {

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.connectVertex(10, 20);
        graph.connectVertex(10, 30);

        graph.connectVertex(20, 40);
        graph.connectVertex(20, 50);

        graph.connectVertex(30, 60);
        graph.connectVertex(30, 70);

        graph.connectVertex(40, 80);
        graph.connectVertex(50, 80);
        graph.connectVertex(60, 80);
        graph.connectVertex(70, 80);

        new BFS().traverse(10, graph.adjacencyList);
    }

    private void traverse(int startingVertex, Map<Integer, LinkedList<Integer>> adjacencyList) {
        Map<Integer, Boolean> visited = new LinkedHashMap<>();
        for (Integer node : adjacencyList.keySet()) {
            visited.put(node, false);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startingVertex);

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            if (visited.get(currNode)) continue;
            System.out.print(currNode + " ");
            visited.put(currNode, true);
            queue.addAll(adjacencyList.get(currNode));
        }
    }
}
