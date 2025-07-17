// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
class Solution {
    public boolean check(int[] nums) {
        int k=nums.length;
        while(k>=0){
            if(sorted(nums)){
                return true;
            }
            rot(nums);
            k--;
        }
        return false;
    }
    static void rot(int[] nums){
        int temp=nums[0];
        for(int i=0;i<nums.length-1;i++){
            nums[i]=nums[i+1];
        }
        nums[nums.length-1]=temp;
    }
    static boolean sorted(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                return false;
            }
        }
        return true;
    }
}
