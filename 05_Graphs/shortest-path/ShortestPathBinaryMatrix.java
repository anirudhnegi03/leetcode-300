//https://leetcode.com/problems/shortest-path-in-binary-matrix/
class Solution {
    class Pair{
        int x;
        int y;
        int level;
        Pair(int x,int y,int level){
            this.x=x;
            this.y=y;
            this.level=level;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1){
            return -1;
        }
        int n=grid.length;
        int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
        boolean[][] vis=new boolean[n][n];
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0,1));
        vis[0][0] = true;
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int cx=curr.x;
            int cy=curr.y;
            if(cx==n-1 && cy==n-1){
                return curr.level;
            }
            for(int[] dir:dirs){
                int nx=cx+dir[0];
                int ny=cy+dir[1];
                if(nx>=0 && ny>=0 && nx<n && ny<n && grid[nx][ny]==0 && !vis[nx][ny]){
                    q.add(new Pair(nx,ny,curr.level+1));
                    vis[nx][ny] = true; 
                }
            }
        }
        return -1;
    }
}
