class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, word, new HashSet<>(), i, j, 0)) return true;
            }
        }
        
        return false;
    }

    public boolean backtrack(char[][] board, String word, Set<String> visited, int x, int y, int w) {
        if (w >= word.length()) return true;
        if (!valid(board.length, board[0].length, x, y) || visited.contains(node(x, y)) || board[x][y] != word.charAt(w)) return false;
        visited.add(node(x, y));

        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] direction: directions) {
            int i = x + direction[0];
            int j = y + direction[1];
            
            if (backtrack(board, word, visited, i, j, w+1)) return true;
        }

        visited.remove(node(x, y));
        return false;
    }

    public boolean valid(int n, int m, int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }

    public String node(int x, int y) {
        return x + ", " + y;
    }
}