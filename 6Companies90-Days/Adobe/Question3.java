import java.util.HashSet;
import java.util.Set;

public class Question3 {
    
    public int minimumLengthEncoding(String[] words) {
        Trie root = new Trie();
        Set<Trie> set = new HashSet<>();

        for (String s : words) {
            Trie cur = root;
            for (int i = s.length() - 1; i >= 0; i--) {
                cur = cur.next(s.charAt(i));
            }
            cur.word = s;
            set.add(cur);
        }

        int ans = 0;

        for (Trie trie : set) {
            if (trie.count == 0) {
                ans += trie.word.length() + 1;
            }
        }

        return ans;
    }

    static class Trie {
        Trie[] links = new Trie[26];
        int count = 0;
        String word = null;

        Trie next(char c) {
            int idx = c - 'a';
            if (links[idx] == null) {
                links[idx] = new Trie();
                count++;
            }
            return links[idx];
        }
    }
}

