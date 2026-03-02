class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        // Multiply from right to left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                
                // Indices in the result array
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p2] = sum % 10;   // Ones place
                pos[p1] += sum / 10;  // Carry to the next position
            }
        }

        // Build the final string
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            // Skip leading zeros unless the string is empty (handle "0" case)
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}