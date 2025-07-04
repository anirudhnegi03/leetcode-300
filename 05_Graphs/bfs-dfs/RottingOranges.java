// https://leetcode.com/problems/rotting-oranges/

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    static class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int orangesRotting(int[][] grid) {
        int fresh=0;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int t=0;
        int[][] dirs=new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        while(!q.isEmpty() && fresh>0){
            int n=q.size();
            for(int i=0;i<n;i++){
                Pair curr=q.poll();
                int cx=curr.x;
                int cy=curr.y;
                for(int[] dir:dirs){
                    int nx=cx+dir[0];
                    int ny=cy+dir[1];
                    if(nx<0 || ny<0 || nx>=grid.length || ny>=grid[0].length){
                        continue;
                    }else{
                        if(grid[nx][ny]==1){
                            fresh--;
                            grid[nx][ny]=2;
                            q.add(new Pair(nx,ny));
                        }
                    }
                } 
            }
            t++;
        }
        return fresh==0?t:-1;
    }
}
