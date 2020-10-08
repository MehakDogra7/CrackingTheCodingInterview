package InterviewBit.GraphDSAndAlgo;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class DFS {

    static Map<Integer, Boolean> visited = new LinkedHashMap<>();

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

        for (Integer node : graph.adjacencyList.keySet()) {
            visited.put(node, false);
        }

        new DFS().traverse(10, graph.adjacencyList);


    }

    private void traverse(int startingVertex, Map<Integer, LinkedList<Integer>> adjacencyList) {
        if (visited.get(startingVertex)) return;

        System.out.print(startingVertex + " ");
        visited.put(startingVertex, true);
        for (Integer adjacentNode : adjacencyList.get(startingVertex)) {
            traverse(adjacentNode, adjacencyList);
        }
    }
}
