class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();

        // Edge case: needle cannot be longer than haystack
        if (nLen > hLen) {
            return -1;
        }

        // Iterate through haystack, only as far as the needle can fit
        for (int i = 0; i <= hLen - nLen; i++) {
            // Check if the substring starting at i matches the needle
            if (haystack.substring(i, i + nLen).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}