// https://leetcode.com/problems/move-zeroes/
class Solution {
    public void moveZeroes(int[] nums) {
        int in=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[in]=nums[i];
                in++;
            }
        }
        while(in<nums.length){
            nums[in++]=0;
        }
    }
}
