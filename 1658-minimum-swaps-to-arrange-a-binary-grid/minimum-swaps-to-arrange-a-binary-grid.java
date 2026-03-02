class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailingZeros = new int[n];
        
        // 1. Count trailing zeros for each row
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    count++;
                } else {
                    break;
                }
            }
            trailingZeros[i] = count;
        }
        
        int totalSwaps = 0;
        
        // 2. Greedy placement
        for (int i = 0; i < n; i++) {
            int targetRequired = n - 1 - i;
            int foundIdx = -1;
            
            // Find the first row that satisfies the zero requirement
            for (int j = i; j < n; j++) {
                if (trailingZeros[j] >= targetRequired) {
                    foundIdx = j;
                    break;
                }
            }
            
            // If no row found, it's impossible
            if (foundIdx == -1) return -1;
            
            // 3. Move the found row to the current position i (adjacent swaps)
            for (int k = foundIdx; k > i; k--) {
                int temp = trailingZeros[k];
                trailingZeros[k] = trailingZeros[k - 1];
                trailingZeros[k - 1] = temp;
                totalSwaps++;
            }
        }
        
        return totalSwaps;
    }
}