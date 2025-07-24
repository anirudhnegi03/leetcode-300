//https://leetcode.com/problems/unique-paths-ii/
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        // int[][] memo=new int[m][n];;
        // return helper(obstacleGrid,m-1,n-1,memo);
        
        int[][] dp=new int[m][n];  
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==1){
                break;
            }
            dp[i][0]=1;
        }
        for(int j=0;j<n;j++){
            if(obstacleGrid[0][j]==1){
                break;
            }
            dp[0][j]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    static int helper(int[][] obstacleGrid,int m,int n,int[][] memo){
        if(m==0 && n==0 && obstacleGrid[m][n]==0){
            return 1;
        }
        if(m<0 || n<0){
            return 0;
        }
        if(obstacleGrid[m][n]==1){
            return 0;
        }
        if(memo[m][n]!=0){
            return memo[m][n];
        }
        memo[m][n]=helper(obstacleGrid,m-1,n,memo)+helper(obstacleGrid,m,n-1,memo);
        return memo[m][n];
    }
}
