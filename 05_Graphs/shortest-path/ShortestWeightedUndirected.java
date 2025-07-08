// https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1
class Solution {
    class Pair {
        int dist;
        int node;

        Pair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
         ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            // Undirected graph
            adj.get(u).add(new Pair(w, v));
            adj.get(v).add(new Pair(w, u));
        }
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = i; 
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);
        dist[1] = 0;
        pq.add(new Pair(0, 1));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int d = curr.dist;
            int u = curr.node;

            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                int w = neighbor.dist;

                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    parent[v] = u;
                    pq.add(new Pair(dist[v], v));
                }
            }
        }
        if (dist[n] == Integer.MAX_VALUE) {
            return Arrays.asList(-1);
        }
        LinkedList<Integer> path = new LinkedList<>();
        int node = n;
        while (parent[node] != node) {
            path.addFirst(node);
            node = parent[node];
        }
        path.addFirst(1); 
        path.addFirst(dist[n]);

        return path;

    }
}
