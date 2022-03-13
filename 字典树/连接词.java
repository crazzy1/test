package 字典树;

import java.util.*;

public class 连接词 {
    
}
class Solution {
    Trie trie = new Trie();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        ArrayList<String> ans = new ArrayList<>();
        Arrays.sort(words,(a,b) -> (a.length() - b.length()));
        
        for(String i : words){
            if(i.length()==0) continue;
            if(dfs(i,0)) ans.add(i);
            else insert(i);
        }
        return ans;
    }

    public boolean dfs(String word, int start) {
        
        

       if(start == word.length()) return true;
       Trie t = trie;
       for(int i = start; i < word.length(); ++i){
           
           
           
           
           t = t.node[word.charAt(i) - 'a'];
           if(t == null) return false;
           if(t.isEnd ) {
               if (dfs(word, i + 1)) {
                    return true;
                }
           }
       }
       return false;
    }
    
    public void insert(String word) {
        Trie t = trie;
       for(int i = 0; i < word.length(); ++i){
           if(t.node[word.charAt(i) - 'a'] == null){
               t.node[word.charAt(i) - 'a'] = new Trie();
           }
           t = t.node[word.charAt(i) - 'a'];
       }
       t.isEnd = true;
    }
}

class Trie {
    Trie[] node;
    boolean isEnd;
    public Trie() {
       node = new Trie[26];
       isEnd = false;
    }
}
