https://takeuforward.org/plus/dsa/problems/frog-jump-with-k-distances
class Solution {
    public int frogJump(int n, int k, int[] heights) {
        int[] dp = new int[n];
        dp[0] = 0;  // No cost to start at step 0

        for (int i = 1; i < n; i++) {
            int minEnergy = Integer.MAX_VALUE;

            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    minEnergy = Math.min(minEnergy, jump);
                }
            }

            dp[i] = minEnergy;
        }

        return dp[n - 1];
    }
}
