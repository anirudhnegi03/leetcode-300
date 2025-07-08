//https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1

class Solution {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int V = adj.size();
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true;
        dist[src] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int neigh : adj.get(curr)) {
                if (!visited[neigh]) {
                    visited[neigh] = true;
                    dist[neigh] = dist[curr] + 1;
                    q.add(neigh);
                }
            }
        }
        return dist;
    }
}
