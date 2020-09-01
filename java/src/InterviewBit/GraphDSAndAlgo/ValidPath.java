package InterviewBit.GraphDSAndAlgo;

public class ValidPath {

    public static void main(String[] args) {
        int x = 5, y = 5, N = 2, R = 1;
        int[] A = {1, 3}, B = {3, 3};
        System.out.println(new ValidPath().solve(x, y, N, R, A, B));
    }

    public String solve(int A, int B, int C, int D, int[] E, int[] F) {
        int[][] graph = new int[A + 1][B + 1];

        for (int i = 0; i < A + 1; i++) {
            for (int j = 0; j < B + 1; j++) {
                //distance b/w circle[k].centre, currCell <= radius  than make it un-visitable
                for (int k = 0; k < C; k++) {
                    int currCircleCentreX = E[k], currCircleCentreY = F[k];
                    double dist = getDistance(i, j, currCircleCentreX, currCircleCentreY);
                    if (dist <= D) {
                        graph[i][j] = -1;
                        break;
                    }
                }
            }
        }
        dfs(graph, 0, 0);
        return graph[A][B] == 1 ? "YES" : "NO";
    }

    private void dfs(int[][] A, int row, int column) {
        A[row][column] = 1;

        int[][] paths = {
                {-1, 0}, {-1, 1}, {0, 1}, {1, 1},
                {1, 0}, {1, -1}, {0, -1}, {-1, -1}
        };

        for (int path = 0; path < paths.length; path++) {
            int neighbourRow = row + paths[path][0], neighbourColumn = column + paths[path][1];
            if (neighbourRow >= 0 && neighbourRow < A.length &&
                    neighbourColumn >= 0 && neighbourColumn < A[0].length) {
                if (A[neighbourRow][neighbourColumn] == 0)
                    dfs(A, neighbourRow, neighbourColumn);
            }
        }
    }

    private double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((Math.pow(x2 - x1, 2)) + Math.pow(y2 - y1, 2));
    }
}
