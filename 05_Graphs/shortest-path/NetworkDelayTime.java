//https://leetcode.com/problems/network-delay-time/
class Solution {
    class GraphPair{
        int val,weight;
        GraphPair(int val,int weight){
            this.val=val;
            this.weight=weight;
        }
    }
    class Pair{
        int node,time;
        Pair(int node,int time){
            this.node=node;
            this.time=time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<GraphPair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            adj.get(u).add(new GraphPair(v,w));
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.time-b.time);
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int node=curr.node;
            int time=curr.time;

            if (time > dist[node]) continue;

            for(GraphPair neigh:adj.get(node)){
                int next=neigh.val;
                int weight=neigh.weight;
                int newTime=weight+time;
                if (newTime < dist[next]) {
                    dist[next] = newTime;
                    pq.add(new Pair(next, newTime));
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}
