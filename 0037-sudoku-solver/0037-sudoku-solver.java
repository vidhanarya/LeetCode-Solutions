class Solution {
    Set<Character>[] rowSet;
    Set<Character>[] colSet;
    Set<Character>[] gridSet;
    
    public void solveSudoku(char[][] board) {
        rowSet = new HashSet[9];
        colSet = new HashSet[9];
        gridSet = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            gridSet[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                set(board, r, c, board[r][c]);
            }
        }

        backtrack(board, 0, 0);
        return;
    }

    private boolean backtrack(char[][] board, int i, int j) {
        if (i == 9 && j == 0) return true;
        if (board[i][j] != '.') return backtrack(board, i + (j+1) / 9, (j+1) % 9);

        for (char n = '1'; n <= '9'; n++) {
            if (!canSet(board, i, j, n)) continue;

            set(board, i, j, n);
            if (backtrack(board, i + (j+1) / 9, (j+1) % 9)) {
                return true;
            }
            reset(board, i, j);
        }

        return false;
    }

    private boolean canSet(char[][] board, int r, int c, char n) {
        if (board[r][c] != '.') return false;
        
        return (!(rowSet[r].contains(n) || colSet[c].contains(n) || gridSet[3 * (r / 3) + c / 3].contains(n)));
    }

    private void set(char[][] board, int r, int c, char n) {
        board[r][c] = n;
        rowSet[r].add(n);
        colSet[c].add(n);
        gridSet[3 * (r / 3) + c / 3].add(n);
    }

    private void reset(char[][] board, int r, int c) {
        char n = board[r][c];
        board[r][c] = '.';
        rowSet[r].remove(n);
        colSet[c].remove(n);
        gridSet[3 * (r / 3) + c / 3].remove(n);
    }
}
