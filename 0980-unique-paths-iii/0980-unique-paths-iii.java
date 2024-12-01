class Solution {
    int uniquePaths;
    int walkableNodes;

    public int uniquePathsIII(int[][] grid) {
        this.uniquePaths = 0;
        this.walkableNodes = 0;
        int x = 0, y = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != -1) this.walkableNodes++;
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }

        Set<String> visited = new HashSet<>();
        visited.add(node(x, y));
        dfs(visited, grid, x, y);
        return uniquePaths;
    }

    public void dfs(Set<String> visited, int[][] grid, int x, int y) {
        if (!valid(grid.length, grid[0].length, x, y) || grid[x][y] == -1) return;
        if (grid[x][y] == 2) {
            if (visited.size() == this.walkableNodes) this.uniquePaths++;
            return;
        }

        int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int[] direction: directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            String n = node(newX, newY);
            if (visited.contains(n)) continue;

            visited.add(n);
            dfs(visited, grid, newX, newY);
            visited.remove(n);
        }
    }

    public boolean valid(int n, int m, int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }

    public String node(int x, int y) {
        return x + ", " + y;
    }
}