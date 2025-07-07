//https://leetcode.com/problems/alien-dictionary/editorial/
class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character,List<Character>> graph=new HashMap<>();
      boolean[] present=new boolean[26];
      int[] inDegree=new int[26];
      StringBuilder ans=new StringBuilder();

      for (String word : words) {
            for (char ch : word.toCharArray()) {
                present[ch - 'a'] = true;
                graph.putIfAbsent(ch, new ArrayList<>());
            }
        }
      

      for(int i=0;i<words.length-1;i++){
        String w1=words[i];
        String w2=words[i+1];
        boolean fd=false;
        int minLen = Math.min(w1.length(), w2.length());
        
        for (int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    inDegree[c2 - 'a']++;
                    fd = true;
                    break;
                }
        }
        if(fd==false && w1.length() > w2.length()){
            return "";
        }

      }
      Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (present[i] && inDegree[i] == 0) {
                queue.add((char) (i + 'a'));
            }
        }
    while (!queue.isEmpty()) {
            char curr = queue.poll();
            ans.append(curr);
            for (char neighbor : graph.get(curr)) {
                inDegree[neighbor - 'a']--;
                if (inDegree[neighbor - 'a'] == 0) {
                    queue.add(neighbor);
                }
            }
        }
    return ans.length() == graph.size() ? ans.toString() : "";
     
      
      
    }
}
