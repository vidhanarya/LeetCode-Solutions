class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;

                rowCount[i]++;
                colCount[j]++;
            }
        }

        int numConnected = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                if (rowCount[i] <= 1 && colCount[j] <= 1) continue;

                numConnected++;
            }
        }

        return numConnected;
    }
}