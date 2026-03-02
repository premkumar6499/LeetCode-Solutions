class Solution {
    public String intToRoman(int num) {
        // Arrays representing values and their corresponding Roman symbols in descending order
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        // Loop through each value
        for (int i = 0; i < values.length; i++) {
            // While the current value can be subtracted from num
            while (num >= values[i]) {
                num -= values[i];
                roman.append(symbols[i]);
            }
        }

        return roman.toString();
    }
}