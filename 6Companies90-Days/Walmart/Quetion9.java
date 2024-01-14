/*
 Question 9 
 Given an array of strings words and an integer k, return the k most frequent strings.
Return the answer sorted by the frequency from highest to lowest. 
Sort the words with the same frequency by their lexicographical order.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Quetion9 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> mp = new HashMap<>();
        for (String s : words) {
            mp.put(s, mp.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((p1, p2) -> {
            if (p1.val == p2.val)
                return p1.s.compareTo(p2.s);
            else
                return p2.val - p1.val;
        });
        for (String s : mp.keySet()) {
            pq.add(new pair(s, mp.get(s)));
        }

         List<String>ans = new ArrayList();
        while(k-->0)ans.add(pq.poll().s);
        return ans;

    }
    
    class pair {
        String s;
        int val;

        pair(String s, int val) {
            this.s = s;
            this.val = val;
        }
    }

}