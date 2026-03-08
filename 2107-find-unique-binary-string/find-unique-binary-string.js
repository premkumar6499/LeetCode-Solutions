/**
 * @param {string[]} nums
 * @return {string}
 */
var findDifferentBinaryString = function(nums) {
    let result = "";
    
    for (let i = 0; i < nums.length; i++) {
        // Look at the character at the diagonal: nums[i][i]
        // If it's '0', add '1' to result. If it's '1', add '0'.
        result += nums[i][i] === '0' ? '1' : '0';
    }
    
    return result;
};