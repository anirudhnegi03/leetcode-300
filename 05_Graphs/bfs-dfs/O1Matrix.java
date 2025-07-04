import java.util.*;

public class O1Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dist=new int[mat.length][mat[0].length];
        boolean[][] vis = new boolean[mat.length][mat[0].length];
        Queue<int[]> q = new LinkedList<>();
        int m=mat.length;
        int n=mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }

        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int cx=curr[0];
            int cy=curr[1];
            for(int[] dir:dirs){
                int nx=cx+dir[0];
                int ny=cy+dir[1];
                if(nx>=0 && ny>=0 && nx<mat.length && ny<mat[0].length && !vis[nx][ny]){
                    dist[nx][ny]=1+dist[cx][cy];
                    vis[nx][ny]=true;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        return dist;
    }
}
