//https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
class Solution {
    class DSU{
        Map<Integer,Integer> parent=new HashMap<>();
        int find(int x){
            if (!parent.containsKey(x)) {
            parent.put(x, x); 
            }
            if (parent.get(x) != x) {
                parent.put(x, find(parent.get(x))); 
            }
            return parent.get(x);
        }
        void union(int x, int y) {
            parent.put(find(x), find(y)); 
        }
    }
    
    public int removeStones(int[][] stones) {
        DSU dsu = new DSU();
        for(int[] stone:stones){
            dsu.union(stone[0], stone[1] + 10001);
        }
        Set<Integer> uniqueRoots = new HashSet<>();
        for (int[] stone : stones) {
            uniqueRoots.add(dsu.find(stone[0]));
        }

    return stones.length - uniqueRoots.size();
    }
}
