// https://leetcode.com/problems/max-consecutive-ones/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                int c=1;
                i++;
                while(i<nums.length && nums[i]==1){
                    i++;
                    c++;
                }
                max=Math.max(max,c);
            }
        }
        return max;
    }
}
