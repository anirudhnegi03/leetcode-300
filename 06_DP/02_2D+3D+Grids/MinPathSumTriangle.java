//https://leetcode.com/problems/triangle/
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // return helper(0,0,triangle,new int[triangle.size()][triangle.get(triangle.size()-1).size()]);
        int m=triangle.size();
        int n=triangle.get(m-1).size();
        int[][] dp=new int[m][n];
        for(int i=0;i<n;i++){
            dp[m-1][i]=triangle.get(m-1).get(i);
        }
        for(int i=m-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[i][j]=triangle.get(i).get(j)+Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];

    }
    static int helper(int row,int col,List<List<Integer>> triangle,int[][] memo){
        if(row==triangle.size()){
            return 0;
        }
        if(memo[row][col]!=0){
            return memo[row][col];
        }
        memo[row][col]= triangle.get(row).get(col)+Math.min(helper(row+1,col,triangle,memo),helper(row+1,col+1,triangle,memo));
        return memo[row][col];
    }
}
