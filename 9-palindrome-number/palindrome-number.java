class Solution {
    public boolean isPalindrome(int x) {
        // Special cases:
        // 1. x < 0: negative numbers are not palindromes
        // 2. x % 10 == 0: if the last digit is 0, the first must be 0 (only 0 works)
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is odd, we can get rid of the middle digit by revertedNumber / 10
        // For example, for 121, at the end of the loop: x = 1, revertedNumber = 12
        // So we check if x == revertedNumber or x == revertedNumber / 10
        return x == revertedNumber || x == revertedNumber / 10;
    }
}