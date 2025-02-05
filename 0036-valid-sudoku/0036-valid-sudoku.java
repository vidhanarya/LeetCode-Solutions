class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!(isRowValid(board, i) && isColValid(board, i))) return false;
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isBoxValid(board, i, j)) return false;
            }
        }

        return true;
    }

    public boolean isRowValid(char[][] board, int r) {
        int[] seen = new int[9];
        for (int c = 0; c < 9; c++) {
            if (board[r][c] == '.') continue;

            seen[board[r][c] - '1']++;
            if (seen[board[r][c] - '1'] > 1) return false;
        }

        return true;
    }

    public boolean isColValid(char[][] board, int c) {
        int[] seen = new int[9];
        for (int r = 0; r < 9; r++) {
            if (board[r][c] == '.') continue;

            seen[board[r][c] - '1']++;
            if (seen[board[r][c] - '1'] > 1) return false;
        }

        return true;
    }

    public boolean isBoxValid(char[][] board, int r, int c) {
        int[] seen = new int[9];
        for (int i = r; i < r+3; i++) {
            for (int j = c; j < c+3; j++) {
                if (board[i][j] == '.') continue;

                seen[board[i][j] - '1']++;
                if (seen[board[i][j] - '1'] > 1) return false;
            }
        }

        return true;
    }
}