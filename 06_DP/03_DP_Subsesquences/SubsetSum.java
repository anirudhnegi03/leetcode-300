//https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1

class Solution {

    static Boolean isSubsetSum(int arr[], int k) {
        // code here
        // return helper(arr,sum,0,new Boolean[arr.length][sum+1]);
        boolean[][] dp=new boolean[arr.length][k+1];
        for(int i=0;i<arr.length;i++){
            dp[i][0]=true;
        }
        int n=arr.length;
        if (arr[0] <= k)
            dp[0][arr[0]] = true;
        
        for (int i = 1; i < n; i++) {
            for (int sum = 1; sum <= k; sum++) {
                boolean notTake = dp[i - 1][sum];
                boolean take = false;
                if (arr[i] <= sum)
                    take = dp[i - 1][sum - arr[i]];
                dp[i][sum] = take || notTake;
            }
        }

        return dp[n - 1][k];

    }
    static Boolean helper(int[] arr,int tar,int i,Boolean[][] memo){
        if(tar==0){
            return true;
        }
        if(i==arr.length){
            return false;
        }
        if(memo[i][tar]!=null){
            return memo[i][tar];
        }
        Boolean notTake=helper(arr,tar,i+1,memo);
        Boolean take=false;
        if(arr[i]<=tar){
            take=helper(arr,tar-arr[i],i+1,memo);
        }
        memo[i][tar]= notTake || take;
        return memo[i][tar];
    }
}
