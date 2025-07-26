//https://leetcode.com/problems/minimum-falling-path-sum/
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // int n = matrix.length;
        // int[][] memo = new int[n][n];
        // for (int[] row : memo) Arrays.fill(row, Integer.MAX_VALUE);

        // int minSum = Integer.MAX_VALUE;
        // for (int col = 0; col < n; col++) {
        //     minSum = Math.min(minSum, minPath(matrix, 0, col, memo));
        // }

        // return minSum;
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = matrix[n - 1][j];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int down = dp[i + 1][j];
                int leftDiag = j > 0 ? dp[i + 1][j - 1] : Integer.MAX_VALUE;
                int rightDiag = j < n - 1 ? dp[i + 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(down, Math.min(leftDiag, rightDiag));
            }
        }

        int minPath = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minPath = Math.min(minPath, dp[0][j]);
        }
        return minPath;
    }

    static int minPath(int[][] matrix, int row, int col, int[][] memo) {
        int n = matrix.length;
        if (col < 0 || col >= n) return Integer.MAX_VALUE;
        if (row == n - 1) return matrix[row][col];

        if (memo[row][col] != Integer.MAX_VALUE) return memo[row][col];

        int down = minPath(matrix, row + 1, col, memo);
        int left = minPath(matrix, row + 1, col - 1, memo);
        int right = minPath(matrix, row + 1, col + 1, memo);

        memo[row][col] = matrix[row][col] + Math.min(down, Math.min(left, right));
        return memo[row][col];
    }
}
