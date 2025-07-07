// https://www.geeksforgeeks.org/problems/topological-sort/1
class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int[] inDegree=new int[V];
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            inDegree[v]++;
            adj.get(u).add(v);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            ans.add(curr);
            for(int neigh:adj.get(curr)){
                inDegree[neigh]--;
                if(inDegree[neigh]==0){
                    q.add(neigh);
                }
            }
        }

        // boolean[] vis=new boolean[V];
        // Stack<Integer> st=new Stack<>();
        // for(int i=0;i<V;i++){
        //     if(!vis[i]){
        //         dfs(i,adj,vis,st);
        //     }
            
        // }
        // while(!st.isEmpty()){
        //     ans.add(st.pop());
        // }
        
        
        
        return ans;
    }
    static void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis,Stack<Integer> st){
        vis[node]=true;
        for(int neigh:adj.get(node)){
            if(!vis[neigh]){
                dfs(neigh,adj,vis,st);
            }
        }
        st.push(node);
    }
}
