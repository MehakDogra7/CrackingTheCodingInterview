package InterviewBit.GraphDSAndAlgo;

import java.util.*;

public class CloneGraph {
    public static void main(String[] args) {
        UndirectedGraphNode a = new UndirectedGraphNode(1);
        UndirectedGraphNode b = new UndirectedGraphNode(2);
        UndirectedGraphNode c = new UndirectedGraphNode(3);
        UndirectedGraphNode d = new UndirectedGraphNode(4);

        a.neighbors.add(b);
        a.neighbors.add(c);

        b.neighbors.add(d);
        c.neighbors.add(d);

        UndirectedGraphNode newRoot = new CloneGraph().cloneGraph(a);
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Map<UndirectedGraphNode, Boolean> visited = new HashMap<>();
        UndirectedGraphNode newRoot = new UndirectedGraphNode(node.label);
        map.put(node, newRoot);

        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            if (visited.get(curr) != null) continue;
            visited.put(curr, true);
            UndirectedGraphNode undirectedGraphNode = map.get(curr);
            for (UndirectedGraphNode neighbour : curr.neighbors) {
                UndirectedGraphNode newNeighbour;
                if (map.containsKey(neighbour)) newNeighbour = map.get(neighbour);
                else {
                    newNeighbour = new UndirectedGraphNode(neighbour.label);
                    map.put(neighbour, newNeighbour);
                }
                undirectedGraphNode.neighbors.add(newNeighbour);
                queue.add(neighbour);
            }
        }
        return newRoot;
    }

    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
}
