class Solution {
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int[][] grid = new int[row][col];
        for (int i = 0; i < cells.length; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = i + 1;
        }

        int left = 0, right = 20002;
        while (left < right) {
            int mid = right - (right - left) / 2;

            if (canTravelToBottom(grid, row, col, mid)) left = mid;
            else right = mid - 1;
        }

        return left;
    }

    public boolean canTravelToBottom(int[][] grid, int n, int m, int time) {
        Queue<Pair<Integer, Integer>> bfs = new LinkedList<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        for (int i = 0; i < m; i++) {
            if (grid[0][i] <= time) continue;
            bfs.offer(new Pair<>(0, i));
            visited.add(new Pair<>(0, i));
        }

        while (!bfs.isEmpty()) {
            Pair<Integer, Integer> p = bfs.poll();
            if (p.getKey() == n - 1) return true;

            for (int[] direction: directions) {
                int x = p.getKey() + direction[0];
                int y = p.getValue() + direction[1];
                if (!valid(n, m, x, y) || visited.contains(new Pair<>(x, y)) || grid[x][y] <= time) continue;

                bfs.offer(new Pair<>(x, y));
                visited.add(new Pair<>(x, y));
            }
        }

        return false;
    }

    public boolean valid(int n, int m, int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
}