import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        // 1. Create a list of numbers [1, 2, 3, ..., n]
        // 2. Precompute factorial values
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
            numbers.add(i);
        }

        // 3. Adjust k to be 0-indexed
        k--;

        // 4. Determine each digit one by one
        for (int i = 1; i <= n; i++) {
            // How many permutations exist for the remaining (n - i) slots
            int index = k / factorial[n - i];
            
            // Append the number at that index to our result
            sb.append(numbers.get(index));
            
            // Remove that number from the list so it isn't reused
            numbers.remove(index);
            
            // Update k for the next position
            k -= index * factorial[n - i];
        }

        return sb.toString();
    }
}
