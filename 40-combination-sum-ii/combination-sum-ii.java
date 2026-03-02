import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        // 1. Sort to handle duplicates and enable pruning
        Arrays.sort(candidates);
        backtrack(results, new ArrayList<>(), candidates, target, 0);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> currentPath, int[] candidates, int remaining, int start) {
        if (remaining == 0) {
            // Found a valid combination
            results.add(new ArrayList<>(currentPath));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 2. Pruning: If the current number is greater than the remaining target, 
            // no point in checking numbers further to the right (since they are sorted)
            if (candidates[i] > remaining) break;

            // 3. Skip duplicates: If this number is the same as the previous one 
            // in the same recursive level, skip it to avoid duplicate combinations.
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            currentPath.add(candidates[i]);
            // Move to i + 1 because each number can only be used once
            backtrack(results, currentPath, candidates, remaining - candidates[i], i + 1);
            // 4. Backtrack: Remove the last element to try other possibilities
            currentPath.remove(currentPath.size() - 1);
        }
    }
}