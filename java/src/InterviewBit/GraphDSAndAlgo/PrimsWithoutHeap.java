package InterviewBit.GraphDSAndAlgo;

public class PrimsWithoutHeap {

    public static void main(String[] args) {
        int[][] costMatrix = {
                {0, 1, 2, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {1, 0, Integer.MAX_VALUE, 3, 5},
                {2, Integer.MAX_VALUE, 0, 4, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 3, 4, 0, 6},
                {Integer.MAX_VALUE, 5, Integer.MAX_VALUE, 6, 0}
        };

        int numberOfVertices = 5;
        int[][] t = new int[numberOfVertices - 1][2];
        int[][] edge = {
                {0, 1, 1},
                {0, 2, 2},
                {1, 3, 3},
                {1, 4, 5},
                {2, 3, 4},
                {3, 4, 6}
        };

        int minCost = prims(edge, costMatrix, numberOfVertices, t);
        System.out.println("Minimum Cost: " + minCost);
        for (int[] ints : t) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }

    private static int prims(int[][] edge, int[][] costMatrix, int numberOfVertices, int[][] t) {
        int minEdgeIndex = 0, minCost = 0;
        int[] near = new int[numberOfVertices];

        for (int i = 1; i < edge.length; i++) {
            if (edge[i][2] < edge[minEdgeIndex][2]) minEdgeIndex = i;
        }
        int k = edge[minEdgeIndex][0], l = edge[minEdgeIndex][1];
        minCost = edge[minEdgeIndex][2];
        t[0][0] = k;
        t[0][1] = l;

        for (int i = 0; i < numberOfVertices; i++) {
            if (costMatrix[i][l] < costMatrix[i][k]) near[i] = l;
            else near[i] = k;
        }
        near[k] = near[l] = -1;
        for (int i = 1; i < numberOfVertices - 1; i++) {
            int j = -1, min = Integer.MAX_VALUE;

            for (int x = 0; x < near.length; x++) {
                if (near[x] != -1 && costMatrix[x][near[x]] < min) {
                    j = x;
                    min = costMatrix[x][near[x]];
                }
            }
            t[i][0] = near[j];
            t[i][1] = j;
            minCost += costMatrix[j][near[j]];
            near[j] = -1;

            for (int m = 0; m < numberOfVertices; m++) {
                if (near[m] != -1 && costMatrix[m][near[m]] > costMatrix[m][j]) near[m] = j;
            }
        }
        return minCost;
    }


}
