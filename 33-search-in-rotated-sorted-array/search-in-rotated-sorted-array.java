class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Determine which side is sorted
            if (nums[left] <= nums[mid]) {
                // Left side is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Target is in the sorted left
                } else {
                    left = mid + 1;  // Target is in the right
                }
            } else {
                // Right side is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;  // Target is in the sorted right
                } else {
                    right = mid - 1; // Target is in the left
                }
            }
        }

        return -1; // Target not found
    }
}