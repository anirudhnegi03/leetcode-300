// https://leetcode.com/problems/surrounded-regions/

import java.util.*;

public class SurroundedRegions {
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void solve(char[][] board) {
        Queue<Pair> q=new LinkedList<>();
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') q.add(new Pair(i, 0));
            if (board[i][n - 1] == 'O') q.add(new Pair(i, n - 1));
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') q.add(new Pair(0, j));
            if (board[m - 1][j] == 'O') q.add(new Pair(m - 1, j));
        }
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int x = curr.x, y = curr.y;

            if (x < 0 || y < 0 || x >= m || y >= n || board[x][y] != 'O') continue;

            board[x][y] = 'S'; 

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                q.add(new Pair(nx, ny));
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; 
                } else if (board[i][j] == 'S') {
                    board[i][j] = 'O'; 
                }
            }
        }
    }
}
