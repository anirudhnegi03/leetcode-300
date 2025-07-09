//https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/

class Solution {
    class Pair {
        int city, cost, stops;
        Pair(int city, int cost, int stops) {
            this.city = city;
            this.cost = cost;
            this.stops = stops;
        }
    }

    class GraphPair {
        int node, weight;
        GraphPair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
}
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<GraphPair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];
            adj.get(u).add(new GraphPair(v,w));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        int[][] visited = new int[n][k+2];
        for (int[] row : visited) Arrays.fill(row, Integer.MAX_VALUE);

        pq.add(new Pair(src, 0, 0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int city = curr.city;
            int cost = curr.cost;
            int stops = curr.stops;

            if (city == dst) return cost;
            if (stops > k) continue;
            
            for(GraphPair neighbor:adj.get(city)){
                int nextCity = neighbor.node;
                int weight = neighbor.weight;
                int newCost = cost + weight;
                if (newCost < visited[nextCity][stops + 1]) {
                    visited[nextCity][stops + 1] = newCost;
                    pq.add(new Pair(nextCity, newCost, stops + 1));
                }
            }
        }
        return -1;

    }
}
