/*
 Question 12
 Given a string s, sort it in decreasing order based on the frequency of the characters. 
 The frequency of a character is the number of times it appears in the string.
Return the sorted string. If there are multiple answers, return any of them.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Question12 {

    public String frequencySort(String s) {

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));

        maxHeap.addAll(frequencyMap.keySet());

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char currentChar = maxHeap.poll();
            int frequency = frequencyMap.get(currentChar);

            for (int i = 0; i < frequency; i++) {
                result.append(currentChar);
            }
        }

        return result.toString();
    }
}

 