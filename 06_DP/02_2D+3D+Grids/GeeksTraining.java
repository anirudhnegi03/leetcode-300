//https://www.geeksforgeeks.org/problems/geeks-training/1


class Solution {
    public int maximumPoints(int points[][]) {
        // code here
        int n=points.length;
        int[][] dp = new int[n][3];

        // --- 1. Base Case: Initialize Day 0 ---
        dp[0][0] = points[0][0];
        dp[0][1] = points[0][1];
        dp[0][2] = points[0][2];

        // --- 2. Build Solution: Iterate from Day 1 to n-1 ---
        for (int day = 1; day < n; day++) {
            // For task 0 on the current day
            dp[day][0] = points[day][0] + Math.max(dp[day - 1][1], dp[day - 1][2]);

            // For task 1 on the current day
            dp[day][1] = points[day][1] + Math.max(dp[day - 1][0], dp[day - 1][2]);
            
            // For task 2 on the current day
            dp[day][2] = points[day][2] + Math.max(dp[day - 1][0], dp[day - 1][1]);
        }

        // --- 3. Final Answer: Max of the last day's tasks ---
        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    
        
        
    }
   
}

 public int maximumPoints(int points[][]) {
        // code here
        int n=points.length;
        int[][] dp = new int[n][3];

        // --- 1. Base Case: Initialize Day 0 ---
        dp[0][0] = points[0][0];
        dp[0][1] = points[0][1];
        dp[0][2] = points[0][2];

        // --- 2. Build Solution: Iterate from Day 1 to n-1 ---
        for (int day = 1; day < n; day++) {
            // For task 0 on the current day
            dp[day][0] = points[day][0] + Math.max(dp[day - 1][1], dp[day - 1][2]);

            // For task 1 on the current day
            dp[day][1] = points[day][1] + Math.max(dp[day - 1][0], dp[day - 1][2]);
            
            // For task 2 on the current day
            dp[day][2] = points[day][2] + Math.max(dp[day - 1][0], dp[day - 1][1]);
        }

        // --- 3. Final Answer: Max of the last day's tasks ---
        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    
        
    }

