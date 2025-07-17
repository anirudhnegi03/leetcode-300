// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int k=1;
        for(int i=1;i<nums.length;i++){
            while(i<n && nums[i]==nums[i-1]){
                i++;
            }
            if(i<n){
                nums[k]=nums[i];
                k++;
            }
            
        }
        return k;
    }
}
