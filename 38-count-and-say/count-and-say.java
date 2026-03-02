class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        String result = "1";
        
        // Generate sequence from 2 up to n
        for (int i = 1; i < n; i++) {
            result = getNext(result);
        }
        
        return result;
    }

    private String getNext(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        while (i < s.length()) {
            char currentDigit = s.charAt(i);
            int count = 0;
            
            // Count consecutive identical digits
            while (i < s.length() && s.charAt(i) == currentDigit) {
                count++;
                i++;
            }
            
            // Append [count][digit]
            sb.append(count).append(currentDigit);
        }
        
        return sb.toString();
    }
}