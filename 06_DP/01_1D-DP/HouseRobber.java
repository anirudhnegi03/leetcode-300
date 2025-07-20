// https://leetcode.com/problems/house-robber/

class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        // Arrays.fill(dp,-1);
        // return helper(nums,0,dp);
        int n=nums.length;
        int prev=nums[0];
        if(n==1){
            return prev;
        }
        int next=Math.max(nums[0],nums[1]);
        if(n==2){
            return next;
        }
        for(int i=2;i<n;i++){
            int curr=Math.max(next,prev+nums[i]);
            prev=next;
            next=curr;
        }
        
        return next;
    }
    // static int helper(int[] nums,int i,int[] dp){
    //    if(i>=nums.length){
    //     return 0;
    //    }
    //    if(dp[i]!=-1){
    //     return dp[i];
    //    }
    //    int inc=nums[i]+helper(nums,i+2,dp);
    //    int exc=helper(nums,i+1,dp);
    //    dp[i]= Math.max(inc,exc);
    //    return dp[i];
    // }
}
