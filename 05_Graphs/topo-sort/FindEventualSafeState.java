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
/*
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;

        // Step 1: Build reversed graph
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            revAdj.add(new ArrayList<>());
        }

        int[] inDegree = new int[V];

        for (int u = 0; u < V; u++) {
            for (int v : graph[u]) {
                revAdj.get(v).add(u);  // reverse the edge
                inDegree[u]++;         // original node's out-degree becomes in-degree
            }
        }

        // Step 2: Queue for nodes with in-degree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        // Step 3: Kahn's BFS
        boolean[] safe = new boolean[V];
        while (!q.isEmpty()) {
            int curr = q.poll();
            safe[curr] = true;
            for (int neighbor : revAdj.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // Step 4: Collect safe nodes
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (safe[i]) {
                ans.add(i);
            }
        }

        Collections.sort(ans); // Return in sorted order
        return ans;
    }
}
*/
