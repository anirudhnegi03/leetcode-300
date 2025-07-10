//https://leetcode.com/problems/number-of-operations-to-make-network-connected/
class Solution {
    class DisjointSet{
        int[] parent;
        int[] size;
        int[] rank;

        DisjointSet(int n){
            parent = new int[n];
            size = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;   
                size[i] = 1;     
                rank[i] = 0;     
            }
        }
        int find(int u){
            if(parent[u]!=u){
                parent[u]=find(parent[u]);
            }
            return parent[u];
        }
        void unionByRank(int u,int v){
            int pu=find(u);
            int pv=find(v);
            if(pu==pv){
                return;
            }
            if(rank[u]>rank[v]){
                parent[v]=pu;
            }else if(rank[v]>rank[u]){
                parent[u]=pv;
            }else{
                parent[pv] = pu;
                rank[pu]++;
            }
        }
        void unionBySize(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if (pu == pv) return;

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds=new DisjointSet(n);
        int cntExtras=0;
        for(int i=0;i<connections.length;i++){
            int u=connections[i][0];
            int v=connections[i][1];
            if(ds.find(u)==ds.find(v)){
                cntExtras++;
            }else{
                ds.unionBySize(u,v);
            }
        }
        int cntC=0;
        for(int i=0;i<n;i++){
            if(ds.find(i)==i){
                cntC++;
            }
        }
        int ans=cntC-1;
        return cntExtras>=ans?ans:-1;
    }
}