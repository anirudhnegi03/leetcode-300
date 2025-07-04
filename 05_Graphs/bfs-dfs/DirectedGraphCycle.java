//https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj=new ArrayList<>(V);
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
        }
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(adj,i,vis,new boolean[V])){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean dfs(List<List<Integer>> adj,int i,boolean[] vis,boolean[] pathVis){
        vis[i]=true;
        pathVis[i]=true;
        for(int neigh:adj.get(i)){
            if(!vis[neigh]){
                if(dfs(adj,neigh,vis,pathVis)){
                    return true;
                }
            }else if(pathVis[neigh]){
                return true;
            }
        }
        pathVis[i]=false;
        return false;
    }
}
