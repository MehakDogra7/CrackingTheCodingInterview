package CollegeAssignments.Algo;

import java.util.Arrays;

public class IsGraphBipartite {

    boolean[] visited;
    int[] initialCount;

    public static void main(String[] args) {
        int[][] graph1 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        int[][] graph2 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};


        System.out.println(new IsGraphBipartite().isBipartite(graph1));
        System.out.println(new IsGraphBipartite().isBipartite(graph2));
    }

    public boolean isBipartite(int[][] graph) {
        int numberOfNodes = graph.length;

        visited = new boolean[numberOfNodes];
        initialCount = new int[numberOfNodes];

        Arrays.fill(visited, false);

        for (int i = 0; i < numberOfNodes; i++) {
            if (!visited[i]) {
                boolean temp = dfs(graph, i, 0);
                if (!temp) return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int currNode, int count) {
        if (visited[currNode]) return (count - initialCount[currNode]) % 2 == 0;

        visited[currNode] = true;
        initialCount[currNode] = count;

        int[] adjacentNodes = graph[currNode];
        for (int adjacentNode : adjacentNodes) {
            boolean temp = dfs(graph, adjacentNode, count + 1);
            if (!temp) return false;
        }

        return true;
    }
}
