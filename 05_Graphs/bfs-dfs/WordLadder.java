//https://leetcode.com/problems/word-ladder/
class Solution {
    static class Pair{
        String word;
        int level;
        Pair(String word,int level){
            this.word=word;
            this.level=level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<String>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            String curr=q.peek().word;
            int level=q.peek().level;
            if(curr.equals(endWord)){
                return level;
            }
            q.poll();
            for(int i=0;i<curr.length();i++){
                for(char j='a';j<='z';j++){
                    char[] rep=curr.toCharArray();
                    rep[i]=j;
                    String nw=new String(rep);
                    if(set.contains(nw)){
                        q.add(new Pair(nw,level+1));
                        set.remove(nw);
                    }
                }
            } 
        }
        return 0;
    }
}
