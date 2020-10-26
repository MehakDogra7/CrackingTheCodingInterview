package InterviewBit.GraphDSAndAlgo;

import java.util.ArrayDeque;
import java.util.Queue;

public class KnightOnChessBoard {
    public static void main(String[] args) {
        System.out.println(new KnightOnChessBoard().knight(8, 8, 1, 1, 8, 8));
    }

    public int knight(int A, int B, int C, int D, int E, int F) {
        int[][] board = new int[A][B];
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                board[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs(board, E - 1, F - 1);
        return board[C - 1][D - 1] == Integer.MAX_VALUE ? -1 : board[C - 1][D - 1];
    }

    private void bfs(int[][] board, int i, int j) {
        if (board[i][j] != Integer.MAX_VALUE) return;

        board[i][j] = 0;

        int[][] paths = {
                {-2, 1}, {-1, 2}, {1, 2}, {2, 1},
                {2, -1}, {1, -2}, {-1, -2}, {-2, -1}
        };
        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.add(new Integer[]{i, j});
        while (!queue.isEmpty()) {
            Integer[] curr = queue.poll();
            for (int[] path : paths) {
                int nextRow = curr[0] + path[0], nextColumn = curr[1] + path[1];
                if (nextRow >= 0 && nextRow < board.length &&
                        nextColumn >= 0 && nextColumn < board[0].length) {
                    if (board[nextRow][nextColumn] > board[curr[0]][curr[1]] + 1) {
                        board[nextRow][nextColumn] = board[curr[0]][curr[1]] + 1;
                        queue.add(new Integer[]{nextRow, nextColumn});
                    }
                }
            }
        }
    }
}
