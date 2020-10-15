package InterviewBit.GraphDSAndAlgo;

import java.util.PriorityQueue;

/**
 * Kruskal's Algorithm
 */
public class CountableIslands {

    public static void main(String[] args) {
        int A = 4;
        int[][] B = {{1, 2, 1},
                {2, 3, 4},
                {1, 4, 3},
                {4, 3, 2},
                {1, 3, 10}};
        System.out.println(new CountableIslands().solve(A, B));
    }

    public int solve(int A, int[][] B) {
        int[] parent = new int[A + 1];
        int minCost = 0;

        for (int vertex = 1; vertex <= A; vertex++)
            parent[vertex] = vertex;

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for (int[] edge : B)
            queue.add(new Edge(edge[0], edge[1], edge[2]));

        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            int p1 = parent[current.v1];
            while (p1 != parent[p1])
                p1 = parent[p1];

            int p2 = parent[current.v2];
            while (p2 != parent[p2])
                p2 = parent[p2];

            if (p1 == p2) //cycle detected
                continue;

            minCost += current.cost;
            parent[p2] = p1;
        }
        return minCost;

    }

    static class Edge implements Comparable<Edge> {
        int v1, v2, cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge edge) {
            return Integer.compare(this.cost, edge.cost);
        }
    }
}
