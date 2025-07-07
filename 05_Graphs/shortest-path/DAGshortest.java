// https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1

// User function Template for Java
class Solution {
    class Pair {
    int node;
    int weight;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            adj.get(u).add(new Pair(v,w));
        }
        int[] in=new int[V];
        for(int i=0;i<adj.size();i++){
            for(Pair neigh:adj.get(i)){
                in[neigh.node]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<in.length;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        List<Integer> topo=new ArrayList<>();
        while(!q.isEmpty()){
            int curr=q.poll();
            topo.add(curr);
            for(Pair neigh:adj.get(curr)){
                in[neigh.node]--;
                if(in[neigh.node]==0){
                    q.add(neigh.node);
                }
            }
        }
        int[] dist=new int[V];
        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[0]=0;
        for(int i=0;i<topo.size();i++){
            int node=topo.get(i);
            if(dist[node]!=Integer.MAX_VALUE){
                for (Pair neigh : adj.get(node)) {
                    if (dist[node] + neigh.weight < dist[neigh.node]) {
                        dist[neigh.node] = dist[node] + neigh.weight;
                    }
                }
            }
        }
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
        
    }
}
