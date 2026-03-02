class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Create 9 sets for rows, 9 for columns, and 9 for boxes
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];

                if (val == '.') continue;

                // Calculate which 3x3 box we are in
                int boxIndex = (r / 3) * 3 + (c / 3);

                // If the value already exists in the row, column, or box, it's invalid
                if (!rows[r].add(val) || !cols[c].add(val) || !boxes[boxIndex].add(val)) {
                    return false;
                }
            }
        }

        return true;
    }
}