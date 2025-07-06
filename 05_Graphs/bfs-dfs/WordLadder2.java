// https://leetcode.com/problems/word-ladder-ii/

class Solution {
    List<List<String>> ans = new ArrayList<>();
    Map<String, Integer> mp = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return ans;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        mp.put(beginWord, 1);
        int wordLen = beginWord.length();

        while (!q.isEmpty()) {
    String word = q.poll();
    int steps = mp.get(word);

    for (int i = 0; i < wordLen; i++) {
        char[] wordArr = word.toCharArray();
        char originalChar = wordArr[i];

        for (char c = 'a'; c <= 'z'; c++) {
            wordArr[i] = c;
            String newWord = new String(wordArr);

            if (!mp.containsKey(newWord) && set.contains(newWord)) {
                q.add(newWord);
                mp.put(newWord, steps + 1); 
            }
        }
        wordArr[i] = originalChar;
    }
}


        if (mp.containsKey(endWord)) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, beginWord, path);
        }

        return ans;
    }

    private void dfs(String word, String beginWord, List<String> path) {
        if (word.equals(beginWord)) {
            List<String> validPath = new ArrayList<>(path);
            Collections.reverse(validPath);
            ans.add(validPath);
            return;
        }

        int currLevel = mp.get(word);
        int wordLen = word.length();

        for (int i = 0; i < wordLen; i++) {
            char[] wordArr = word.toCharArray();
            char originalChar = wordArr[i];

            for (char ch = 'a'; ch <= 'z'; ch++) {
                wordArr[i] = ch;
                String prevWord = new String(wordArr);

                if (mp.containsKey(prevWord) && mp.get(prevWord) == currLevel - 1) {
                    path.add(prevWord);
                    dfs(prevWord, beginWord, path);
                    path.remove(path.size() - 1);
                }
            }
            wordArr[i] = originalChar;
        }
    }
}
