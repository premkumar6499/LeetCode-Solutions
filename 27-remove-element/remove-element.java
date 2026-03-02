class Solution {
    public int removeElement(int[] nums, int val) {
        // k tracks the position for the next element not equal to val
        int k = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // If the current element is not the one we want to remove
            if (nums[i] != val) {
                // Move it to the 'k' position and increment k
                nums[k] = nums[i];
                k++;
            }
        }
        
        // k represents the count of elements not equal to val
        return k;
    }
}