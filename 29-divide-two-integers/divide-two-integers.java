class Solution {
    public int divide(int dividend, int divisor) {
        // Special Case: Overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert both to negative to prevent overflow during conversion
        int a = dividend < 0 ? dividend : -dividend;
        int b = divisor < 0 ? divisor : -divisor;

        int quotient = 0;

        // While dividend is "smaller" (further from zero) than divisor
        while (a <= b) {
            int value = b;
            int multiple = 1;

            // Exponentially increase the subtractor
            // Check value >= -1073741824 to prevent overflow before shifting
            while (value >= -1073741824 && a <= (value << 1)) {
                value <<= 1;
                multiple <<= 1;
            }

            a -= value;
            quotient += multiple;
        }

        return isNegative ? -quotient : quotient;
    }
}