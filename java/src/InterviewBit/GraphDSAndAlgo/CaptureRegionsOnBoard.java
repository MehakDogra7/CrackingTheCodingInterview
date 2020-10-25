package InterviewBit.GraphDSAndAlgo;

import java.util.ArrayList;
import java.util.List;

public class CaptureRegionsOnBoard {

    boolean[][] visited;

    public static void main(String[] args) {

        ArrayList<ArrayList<Character>> A = new ArrayList<>();
        A.add(new ArrayList<>(List.of('X', 'X', 'X', 'X')));
        A.add(new ArrayList<>(List.of('X', 'O', 'O', 'X')));
        A.add(new ArrayList<>(List.of('X', 'X', 'O', 'X')));


        new CaptureRegionsOnBoard().solve(A);
        A.forEach(list -> {
            list.forEach(i -> System.out.print(i + " "));
            System.out.println();
        });
    }

    public void solve(ArrayList<ArrayList<Character>> A) {
        int n = A.size(), m = A.get(0).size();
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            if (A.get(0).get(i) == 'O' && visited[0][i]) dfs(A, 0, i);         //0th Row
            if (A.get(n - 1).get(i) == 'O' && visited[n - 1][i]) dfs(A, n - 1, i);         //last Row
        }
        for (int i = 0; i < n; i++) {
            if (A.get(i).get(0) == 'O' && visited[i][0]) dfs(A, i, 0);         //0th Column
            if (A.get(i).get(m - 1) == 'O' && visited[i][m - 1]) dfs(A, i, m - 1);         //last Column
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) A.get(i).set(j, 'X');
            }
        }
    }

    private void dfs(ArrayList<ArrayList<Character>> A, int i, int j) {
        if (A.get(i).get(j) == 'O' && visited[i][j]) {
            visited[i][j] = false;
            int[][] paths = {
                    {-1, 0}, {0, 1},
                    {1, 0}, {0, -1}
            };
            for (int[] path : paths) {
                int neighbourRow = i + path[0], neighbourColumn = j + path[1];
                if (neighbourRow >= 0 && neighbourRow < A.size() &&
                        neighbourColumn >= 0 && neighbourColumn < A.get(0).size()) {
                    dfs(A, neighbourRow, neighbourColumn);
                }
            }
        }
    }
}
