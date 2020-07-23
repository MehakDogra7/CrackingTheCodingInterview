package Interviewing.io;

public class CountIslands {

    public static void main(String[] args) {
        int[][] A = {
                {0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 1, 0}
        };

        System.out.println(new CountIslands().count(A));
    }

    private int count(int[][] A) {
        int res = 0;

        int rows = A.length, columns = A[0].length;

        boolean[][] visited = new boolean[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (A[row][column] == 0 || visited[row][column])
                    continue;
                dfs(A, row, column, visited);
                res++;
            }
        }

        return res;
    }

    private void dfs(int[][] A, int row, int column, boolean[][] visited) {
        visited[row][column] = true;

        int[][] paths = {
                {1, 1}, {1, 0}, {0, 1}, {-1, -1},
                {-1, 0}, {0, -1}, {-1, 1}, {1, -1}
        };

        for (int path = 0; path < paths.length; path++) {
            int neighbourRow = row + paths[path][0];
            int neighbourColumn = column + paths[path][1];
            if (neighbourRow >= 0 && neighbourRow < A.length &&
                    neighbourColumn >= 0 && neighbourColumn < A[0].length) {
                if (A[neighbourRow][neighbourColumn] == 1 && !visited[neighbourRow][neighbourColumn]) {
                    dfs(A, neighbourRow, neighbourColumn, visited);
                }
            }
        }
    }
}
