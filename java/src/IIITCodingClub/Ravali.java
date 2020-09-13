package IIITCodingClub;

import java.util.Scanner;

public class Ravali {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int row = sc.nextInt(), column = sc.nextInt();
            char[][] maze = new char[row][column];
            dp = new int[row][column];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    maze[i][j] = sc.next().charAt(0);
                    dp[i][j] = -1;
                }
            }

            System.out.println(solve(maze, 0, 0));
            t--;
        }
    }

    private static int solve(char[][] maze, int i, int j) {
        if (i >= maze.length || j == maze[0].length) return 0;
        if (maze[i][j] == '*') return 0;
        if (i == maze.length - 1 && j == maze[0].length - 1) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        int temp = 0;
        if (i == maze.length - 1) {
            temp = solve(maze, i, j + 1);
        } else if (j == maze[0].length - 1) {
            temp = solve(maze, i + 1, j);
        } else {
            int right = solve(maze, i, j + 1);
            int down = solve(maze, i + 1, j);
            temp = right + down;
        }
        dp[i][j] = temp;
        return dp[i][j];
    }

}
