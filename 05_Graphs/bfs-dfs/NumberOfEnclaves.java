// https://leetcode.com/problems/number-of-enclaves/description/
import java.util.*;
public class NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]==1){
                q.add(new int[]{i,0});
            }
            if(grid[i][n-1]==1){
                q.add(new int[]{i,n-1});
            }
        }
        for(int j=0;j<grid[0].length;j++){
            if(grid[0][j]==1){
                q.add(new int[]{0,j});
            }
            if(grid[m-1][j]==1){
                q.add(new int[]{m-1,j});
            }
        }
        int[][] dirs=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int cx=curr[0];
            int cy=curr[1];
            grid[cx][cy]=0;
            for(int[] dir:dirs){
                int nx=cx+dir[0];
                int ny=cy+dir[1];
                if(nx>=0 && ny>=0 && nx<m && ny<n && grid[nx][ny]==1){
                    q.add(new int[]{nx,ny});
                    grid[nx][ny]=0;
                }
            }
        }
        int cnt=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
