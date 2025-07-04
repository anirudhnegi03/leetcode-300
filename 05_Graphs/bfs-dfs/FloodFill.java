// https://leetcode.com/problems/flood-fill/

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    static class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] dirs=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        Queue<Pair> q=new LinkedList<>();
        int originalColor = image[sr][sc];
        if (originalColor == color) {
            return image;
        }
        image[sr][sc]=color;
        q.add(new Pair(sr,sc));

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int cx = curr.x;
            int cy = curr.y;

            for (int[] dir : dirs) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];

                if (nx >= 0 && ny >= 0 && nx < image.length && ny < image[0].length) {
                    if (image[nx][ny] == originalColor) {
                        image[nx][ny] = color;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
        return image;
    }
}
