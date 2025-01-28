class Solution {
    public int findMaxFish(int[][] grid) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int maxFish = 0;

        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] <= 0) continue;

                int currFish = grid[i][j];
                Queue<Pair<Integer, Integer>> bfs = new LinkedList<>();
                bfs.offer(new Pair<>(i, j));
                grid[i][j] = 0;

                while (!bfs.isEmpty()) {
                    Pair<Integer, Integer> pair = bfs.poll();
                    int x = pair.getKey();
                    int y = pair.getValue();

                    for (int[] direction: directions) {
                        int newX = x + direction[0];
                        int newY = y + direction[1];
                        if (newX < 0 || newX >= m || newY < 0 || newY >= n) continue;
                        if (grid[newX][newY] <= 0) continue;

                        currFish += grid[newX][newY];
                        grid[newX][newY] = 0;
                        bfs.offer(new Pair<>(newX, newY));
                    }
                }

                maxFish = Math.max(maxFish, currFish);
            }
        }

        return maxFish;
    }
}