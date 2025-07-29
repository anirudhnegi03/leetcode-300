//https://leetcode.com/problems/partition-equal-subset-sum/
class Solution {
    public boolean canPartition(int[] nums) {
        // int total = 0;
        // for (int num : nums) total += num;

        // if (total % 2 != 0) return false;

        // int target = total / 2;
        // Boolean[][] dp = new Boolean[nums.length][target + 1];

        // return helper(0, target, nums, dp);

        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // If total sum is odd, cannot partition into equal subsets
        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        int n = nums.length;

        // dp[i][j] = can we make sum 'j' using elements from index 0 to i
        boolean[][] dp = new boolean[n][target + 1];

        // Base case: With sum = 0, answer is always true (choose no elements)
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Handle the first element separately
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        // Fill the rest of the DP table
        for (int i = 1; i < n; i++) {
            for (int t = 1; t <= target; t++) {
                boolean notTake = dp[i - 1][t]; // exclude nums[i]
                boolean take = false;
                if (t >= nums[i]) {
                    take = dp[i - 1][t - nums[i]]; // include nums[i]
                }
                dp[i][t] = take || notTake;
            }
        }

        return dp[n - 1][target];
    }

    private boolean helper(int index, int target, int[] nums, Boolean[][] dp) {
        if (target == 0) return true;
        if (index >= nums.length || target < 0) return false;

        if (dp[index][target] != null) return dp[index][target];

        boolean take = helper(index + 1, target - nums[index], nums, dp);
        boolean notTake = helper(index + 1, target, nums, dp);

        return dp[index][target] = take || notTake;
    }
}
