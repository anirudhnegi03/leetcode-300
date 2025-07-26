//https://www.naukri.com/code360/problems/ninja-and-his-friends_3125885?source=youtube&campaign=striver_dp_videos&leftPanelTab=0

import java.util.* ;
import java.io.*; 
public class Solution {
	public static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
        Integer[][][] dp = new Integer[r][c][c];
        return helper(0, 0, c - 1, grid, dp);
	}
    static int helper(int i, int j1, int j2, int[][] grid, Integer[][][] dp) {
        int R = grid.length;
        int C = grid[0].length;

        // Out of bounds
        if (j1 < 0 || j1 >= C || j2 < 0 || j2 >= C) return Integer.MIN_VALUE;

        // Base Case (last row)
        if (i == R - 1) {
            if (j1 == j2) return grid[i][j1];
            return grid[i][j1] + grid[i][j2];
        }

        if (dp[i][j1][j2] != null) return dp[i][j1][j2];

        int max = Integer.MIN_VALUE;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int newJ1 = j1 + dj1;
                int newJ2 = j2 + dj2;

                int value;
                if (j1 == j2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];

                value += helper(i + 1, newJ1, newJ2, grid, dp);
                max = Math.max(max, value);
            }
        }

        return dp[i][j1][j2] = max;
    }
}
