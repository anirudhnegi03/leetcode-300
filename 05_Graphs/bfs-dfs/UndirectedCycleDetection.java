// https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class UndirectedCycleDetection {
    static class Pair{
        int par;
        int node;
        Pair(int par,int node){
            this.par=par;
            this.node=node;
        }
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] vis = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (bfsCycle(i, adj, vis)) return true;
            }
        }

        // dfs        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(i,-1,vis,adj))
                    return true;
            }
        }
        return false;
        
    }
  private boolean dfs(int curr, int par, boolean[] vis, List<List<Integer>> adj) {
    vis[curr] = true;

    for (int neigh : adj.get(curr)) {
        if (!vis[neigh]) {
            if (dfs(neigh, curr, vis, adj)) {
                return true;
            }
        } else if (neigh != par) {
            return true; 
        }
    }

    return false;
}
    private boolean bfsCycle(int start, List<List<Integer>> adj, boolean[] vis) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(-1, start));
        vis[start] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (int neigh : adj.get(curr.node)) {
                if (!vis[neigh]) {
                    vis[neigh] = true;
                    q.add(new Pair(curr.node, neigh));
                } else if (neigh != curr.par) {
                    return true; 
                }
            }
        }

        return false;
    }
}
