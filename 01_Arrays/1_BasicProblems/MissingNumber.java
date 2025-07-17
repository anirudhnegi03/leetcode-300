// https://leetcode.com/problems/missing-number/
class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum=n*(n+1)/2;
        int as=0;
        for(int x:nums){
            as+=x;
        }
        return sum-as;
    }
}
