// https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj=new ArrayList<>(V);
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int[] inDegree=new int[V];
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            inDegree[v]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        int cnt=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            cnt++;
            for(int neigh:adj.get(curr)){
                inDegree[neigh]--;
                if(inDegree[neigh]==0){
                    q.add(neigh);
                }
            }
        }
        return cnt!=V;
        
        // boolean[] vis=new boolean[V];
        // for(int i=0;i<V;i++){
        //     if(!vis[i]){
        //         if(dfs(adj,i,vis,new boolean[V])){
        //             return true;
        //         }
        //     }
        // }
        // return false;
    }
    boolean dfs(List<List<Integer>> adj,int i,boolean[] vis,boolean[] pathVis){
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