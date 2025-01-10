class Solution {
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public int minDays(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if (countIslands(grid, n, m) != 1) return 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 1) continue;

                grid[i][j] = 0;
                if (countIslands(grid, n, m) != 1) return 1;
                grid[i][j] = 1;
            }
        }

        return 2;
    }

    public int countIslands(int[][] grid, int n, int m) {
        int numIslands = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 1) continue;

                numIslands++;
                markVisited(grid, n, m, i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) continue;
                grid[i][j] = 1;
            }
        }

        return numIslands;
    }

    public void markVisited(int[][] grid, int n, int m, int i, int j) {
        Stack<Pair<Integer, Integer>> dfs = new Stack<>();
        dfs.add(new Pair<>(i, j));
        grid[i][j] = 2;

        while (!dfs.empty()) {
            Pair<Integer, Integer> node = dfs.pop();
            int x = node.getKey(), y = node.getValue();
            
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (!valid(n, m, newX, newY) || grid[newX][newY] != 1) continue;

                grid[newX][newY] = 2;
                dfs.add(new Pair<>(newX, newY));
            }
        }
    }

    public boolean valid(int n, int m, int i, int j) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
}