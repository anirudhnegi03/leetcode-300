//https://leetcode.com/problems/find-eventual-safe-states/

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans=new ArrayList<>();
        boolean[] vis=new boolean[graph.length];
        boolean[] pathVis=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if (dfs(i, vis, pathVis, graph)) {
                ans.add(i);
            }
        }
        return ans;
    }
    static boolean dfs(int node,boolean[] vis,boolean[] pathVis,int[][] graph){
        vis[node]=true;
        pathVis[node]=true;
        for(int neigh:graph[node]){
            if(!vis[neigh]){
                if(!dfs(neigh,vis,pathVis,graph)){
                    return false;
                }
            }else if(pathVis[neigh]){
                    return false;
            }
        }
        pathVis[node]=false;
        return true;
    }
}
