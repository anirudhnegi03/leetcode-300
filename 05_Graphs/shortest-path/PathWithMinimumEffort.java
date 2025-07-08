//https://leetcode.com/problems/path-with-minimum-effort/
class Solution {
    class Pair{
    int x, y, effort;
    Pair(int x, int y, int effort) {
        this.x = x;
        this.y = y;
        this.effort = effort;
    }
    }
    public int minimumEffortPath(int[][] heights) {
        int[][] dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        pq.add(new Pair(0,0,0));
        int n = heights.length;
        int m = heights[0].length;
        int[][] effort = new int[n][m];
        for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);
        effort[0][0] = 0;

        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int cx=curr.x;
            int cy=curr.y;
            int ce=curr.effort;
            if (cx == n - 1 && cy == m - 1) return ce;

            for(int[] dir:dirs){
                int nx=dir[0]+cx;
                int ny=dir[1]+cy;
                if(nx>=0 && ny>=0 && nx<heights.length && ny<heights[0].length){
                    int diff = Math.abs(heights[nx][ny] - heights[cx][cy]);
                    int eff = Math.max(ce, diff);
                    if(effort[nx][ny]>eff){
                        pq.add(new Pair(nx,ny,eff));
                        effort[nx][ny]=eff;
                    }
                    

                }
            }
            
        }
        return -1;

    }
}
