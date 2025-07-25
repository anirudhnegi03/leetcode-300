//https://leetcode.com/problems/unique-paths/

class Solution {
    public int uniquePaths(int m, int n) {
        // int[][] memo=new int[m][n];
        // return helper(m-1,n-1,memo);  

        int[][] dp=new int[m][n];  
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int j=0;j<n;j++){
            dp[0][j]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    static int helper(int m,int n,int[][] memo){
        if(m<0 || n<0){
            return 0;
        }
        if(memo[m][n]!=0){
            return memo[m][n];
        }
        if(m==0 && n==0){
            return 1;
        }
        memo[m][n]=helper(m-1,n,memo)+helper(m,n-1,memo);
        return memo[m][n];
    }
}
