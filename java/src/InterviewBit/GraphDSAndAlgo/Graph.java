package InterviewBit.GraphDSAndAlgo;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph {
    public int totalVertices;
    public Map<Integer, LinkedList<Integer>> adjacencyList;

    public Graph(int totalVertices) {
        this.totalVertices = totalVertices;
        adjacencyList = new LinkedHashMap<>();
    }

    public void connectVertex(int v, int w) {
        if (adjacencyList.get(v) == null) {
            LinkedList<Integer> adjacent = new LinkedList<>();
            adjacent.add(w);
            adjacencyList.put(v, adjacent);
        } else {
            adjacencyList.get(v).add(w);
        }

        if (adjacencyList.get(w) == null) {
            LinkedList<Integer> adjacent = new LinkedList<>();
            adjacent.add(v);
            adjacencyList.put(w, adjacent);
        } else {
            adjacencyList.get(w).add(v);
        }
    }
}
