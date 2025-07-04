// https://leetcode.com/problems/number-of-provinces/
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int v=isConnected.length;
        boolean[] vis=new boolean[v];
        int n=0;
        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(isConnected,i,vis);
                n++;
            }
        }
        return n;

    }
    static void dfs(int[][] isConnected,int i,boolean[] vis){
        if(vis[i]){
            return;
        }
        vis[i]=true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !vis[j]) {
                dfs(isConnected, j, vis);
            }
        }
    }
}
