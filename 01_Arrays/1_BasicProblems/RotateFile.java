// https://leetcode.com/problems/rotate-array/description/
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        // while(k>0){
        //     rot(nums);
        //     k--;
        // }
        rev(nums,0,nums.length-1);
        rev(nums,0,k-1);
        rev(nums,k,nums.length-1);
    }
    static void rev(int[] nums,int s,int e){
        while(s<e){
            int temp=nums[s];
            nums[s]=nums[e];
            nums[e]=temp;
            s++;
            e--;
        }
    }
    static void rot(int[] nums){
        int temp=nums[nums.length-1];
        for(int i=nums.length-1;i>0;i--){
            nums[i]=nums[i-1];
        }
        nums[0]=temp;
    }
}
