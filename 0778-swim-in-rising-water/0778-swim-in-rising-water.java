class State {
    int x;
    int y;
    int t;

    State(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] visited = new int[n][n];
        PriorityQueue<State> bfs = new PriorityQueue<>(Comparator.comparingInt(a -> a.t));

        bfs.add(new State(0, 0, grid[0][0]));
        visited[0][0] = grid[0][0];
        while (!bfs.isEmpty()) {
            State state = bfs.poll();
            if (state.x == n-1 && state.y == n-1) {
                return state.t;
            }

            for (int[] direction : directions) {
                int newX = state.x + direction[0];
                int newY = state.y + direction[1];

                if (!isValid(n, newX, newY)) continue;

                int newT = Math.max(state.t, grid[newX][newY]);
                if (visited[newX][newY] != 0 && visited[newX][newY] <= newT) continue;

                bfs.add(new State(newX, newY, newT));
                visited[newX][newY] = newT;
            }
        }

        return 2499;
    }

    private boolean isValid(int n, int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
}