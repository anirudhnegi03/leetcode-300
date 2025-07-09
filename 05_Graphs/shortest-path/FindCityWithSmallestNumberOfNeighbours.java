//https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
class Solution {
    class Pair{
        int node,weight;
        Pair(int node,int weight){
            this.node=node;
            this.weight=weight;
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        ArrayList<List<Integer>> city = new ArrayList<>();
        for(int i=0;i<n;i++){
            city.add(new ArrayList<>());
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
                int u=edges[i][0];
                int v=edges[i][1];
                int w=edges[i][2];
                adj.get(u).add(new Pair(v,w));
                adj.get(v).add(new Pair(u,w));
        }
        for(int i=0;i<n;i++){
            dijkstra(i,adj,distanceThreshold,city);
        }
        int minReachable = Integer.MAX_VALUE;
        int resultCity = -1;
        for (int i = 0; i < n; i++) {
            int reachable = city.get(i).size() - 1; 
            if (reachable <= minReachable) {
                minReachable = reachable;
                resultCity = i;
            }
        }
        return resultCity;
        
    }
    static void dijkstra(int src,ArrayList<ArrayList<Pair>> adj,int thresh, ArrayList<List<Integer>> city){
        int[] dist = new int[adj.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{src, 0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];

            for (Pair neigh : adj.get(node)) {
                int next = neigh.node;
                int weight = neigh.weight;
                if (time + weight < dist[next]) {
                    dist[next] = time + weight;
                    pq.add(new int[]{next, dist[next]});
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] <= thresh) {
                city.get(src).add(i);
            }
        }
    }
}
