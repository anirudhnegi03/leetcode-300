//https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int MOD=100000;
        if(start==end){
                return 0;
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{start,0});
        int[] steps=new int[MOD];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[start] = 0;

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int num=curr[0];
            int step=curr[1];
            for(int n:arr){
                int newnum=(num*n)%MOD;
                int newstep=step+1;
                if(newnum==end){
                    return newstep;
                }
                if(steps[newnum]>newstep){
                    steps[newnum]=newstep;
                    pq.add(new int[]{newnum,newstep});
                }
            }
        }
        return -1;
    }
}
