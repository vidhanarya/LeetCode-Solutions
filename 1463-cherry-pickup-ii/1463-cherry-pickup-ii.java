class Solution {
    Map<String, Integer> memo = new HashMap<>();
    int[][] directions = new int[][]{{1, -1}, {1, 0}, {1, 1}};

    public int cherryPickup(int[][] grid) {
        return maxCherries(grid, 0, 0, 0, grid[0].length-1);
    }

    public int maxCherries(int[][] grid, int x1, int y1, int x2, int y2) {
        String position = getEdge(x1, y1, x2, y2);
        if (memo.containsKey(position)) return memo.get(position);

        int m = grid.length, n = grid[0].length;
        int currCherries = grid[x1][y1];
        if (x1 != x2 || y1 != y2) {
            currCherries += grid[x2][y2];
        }

        int totalCherries = currCherries;
        for (int[] direction1 : directions) {
            for (int[] direction2 : directions) {
                int p1 = x1 + direction1[0], q1 = y1 + direction1[1];
                int p2 = x2 + direction2[0], q2 = y2 + direction2[1];
                if (!valid(m, n, p1, q1) || !valid(m, n, p2, q2)) continue;

                totalCherries = Math.max(totalCherries, currCherries + maxCherries(grid, p1, q1, p2, q2));
            }
        }

        memo.put(position, totalCherries);
        return totalCherries;
    }

    public String getEdge(int x1, int y1, int x2, int y2) {
        return x1 + ", " + y1 + " | " + x2 + ", " + y2;
    }

    public boolean valid(int m, int n, int x, int y) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }
}