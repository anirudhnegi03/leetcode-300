//https://leetcode.com/problems/course-schedule/submissions/1689335948/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V=numCourses;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][1];
            int v=prerequisites[i][0];
            adj.get(u).add(v);
        }
        return !hasCycle(adj);
    }
    static boolean hasCycle(ArrayList<ArrayList<Integer>> adj){
        int[] preIndex=new int[adj.size()];
        for(int i=0;i<adj.size();i++){
            for(int neigh:adj.get(i)){
                preIndex[neigh]++;
            }
        }
        int v=adj.size();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<preIndex.length;i++){
            if(preIndex[i]==0){
                q.add(i);
            }
        }
        int cnt=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            cnt++;
            for(int neigh:adj.get(curr)){
                preIndex[neigh]--;
                if(preIndex[neigh]==0){
                    q.add(neigh);
                }
            }
        }
        return cnt!=v;
    }
}
