import java.util.Arrays;

public class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int totalLen = n + m - 1;
        char[] word = new char[totalLen];
        boolean[] fixed = new boolean[totalLen];
        
        // Fill word with a placeholder
        Arrays.fill(word, '\0');

        // 1. Satisfy all 'T' constraints
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != '\0' && word[i + j] != str2.charAt(j)) {
                        return ""; // Conflicting 'T' requirements
                    }
                    word[i + j] = str2.charAt(j);
                    fixed[i + j] = true;
                }
            }
        }

        // 2. Initial fill: all gaps become 'a' to stay lexicographically small
        for (int i = 0; i < totalLen; i++) {
            if (word[i] == '\0') {
                word[i] = 'a';
            }
        }

        // 3. Resolve 'F' violations
        // If word[i...i+m-1] == str2 but str1[i] == 'F', we must change one character.
        // We change the rightmost non-fixed character in the window to maintain minimality.
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                if (isMatch(word, i, str2)) {
                    boolean changed = false;
                    for (int j = m - 1; j >= 0; j--) {
                        if (!fixed[i + j]) {
                            // Change to 'b' if str2[j] is 'a', otherwise 'a' (already handled by fill)
                            word[i + j] = (str2.charAt(j) == 'a') ? 'b' : 'a';
                            changed = true;
                            break;
                        }
                    }
                    if (!changed) return ""; // No character in this window can be changed
                }
            }
        }

        // 4. Final Verification
        // Changing a character to fix one 'F' might have broken a 'T' or another 'F'.
        for (int i = 0; i < n; i++) {
            boolean currentMatch = isMatch(word, i, str2);
            if (str1.charAt(i) == 'T' && !currentMatch) return "";
            if (str1.charAt(i) == 'F' && currentMatch) return "";
        }

        return new String(word);
    }

    private boolean isMatch(char[] word, int start, String str2) {
        for (int j = 0; j < str2.length(); j++) {
            if (word[start + j] != str2.charAt(j)) return false;
        }
        return true;
    }
}
