import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        // We only need to start at offsets from 0 up to wordLen - 1
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            Map<String, Integer> currentMap = new HashMap<>();
            int count = 0;

            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (counts.containsKey(word)) {
                    currentMap.put(word, currentMap.getOrDefault(word, 0) + 1);
                    count++;

                    // If we have too many of 'word', slide 'left' pointer to remove words
                    while (currentMap.get(word) > counts.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentMap.put(leftWord, currentMap.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // Found a valid concatenation
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    // Not a valid word, reset the window
                    currentMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return result;
    }
}