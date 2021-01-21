package Question450.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 2},
                {0, 1, 2},
                {2, 1, 1}
        };

        System.out.println(new RottenOranges().orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        // Code here
        int n = grid.length, m = grid[0].length, ans = 0;
        Queue<Pair> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) queue.add(new Pair(i, j));
            }
        }
        queue.add(new Pair(-1, -1));
        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            if (queue.isEmpty()) break;
            if (p.equals(new Pair(-1, -1))) {
                queue.add(p);
                ans++;
            } else {
                if (p.r + 1 < n && grid[p.r + 1][p.c] == 1) {
                    grid[p.r + 1][p.c] = 2;
                    queue.add(new Pair(p.r + 1, p.c));
                }
                if (p.r - 1 >= 0 && grid[p.r - 1][p.c] == 1) {
                    grid[p.r - 1][p.c] = 2;
                    queue.add(new Pair(p.r - 1, p.c));
                }
                if (p.c + 1 < m && grid[p.r][p.c + 1] == 1) {
                    grid[p.r][p.c + 1] = 2;
                    queue.add(new Pair(p.r, p.c + 1));
                }
                if (p.c - 1 >= 0 && grid[p.r][p.c - 1] == 1) {
                    grid[p.r][p.c - 1] = 2;
                    queue.add(new Pair(p.r, p.c - 1));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }

        return ans;
    }

    private static class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            Pair p = (Pair) o;
            return p.r == this.r && p.c == this.c;
        }
    }
}
