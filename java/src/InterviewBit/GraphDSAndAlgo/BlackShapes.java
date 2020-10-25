package InterviewBit.GraphDSAndAlgo;

public class BlackShapes {

    boolean[][] visited;

    public static void main(String[] args) {
        String[] A = {"OOOXOOO", "OOXXOXO", "OXOOOXO" };
        System.out.println(new BlackShapes().black(A));
    }

    public int black(String[] A) {
        int n = A.length, m = A[0].length();
        visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i].charAt(j) == 'X' && !visited[i][j]) {
                    dfs(A, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(String[] A, int i, int j) {
        if (A[i].charAt(j) == 'O' || visited[i][j]) return;

        visited[i][j] = true;

        int[][] paths = {
                {-1, 0}, {0, 1},
                {1, 0}, {0, -1}
        };
        for (int[] path : paths) {
            int neighbourRow = i + path[0], neighbourColumn = j + path[1];
            if (neighbourRow >= 0 && neighbourRow < A.length &&
                    neighbourColumn >= 0 && neighbourColumn < A[0].length()) {
                dfs(A, neighbourRow, neighbourColumn);
            }
        }
    }
}
