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
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int left = 0, right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canSwimWithinTime(grid, n, mid)) right = mid;
            else left = mid + 1;
        }

        return left;
    }

    public boolean canSwimWithinTime(int[][] grid, int n, int time) {
        if (grid[0][0] > time) return false;

        Stack<State> dfs = new Stack<>();
        Set<String> visited = new HashSet<>();
        dfs.push(new State(0, 0, grid[0][0]));
        visited.add(getEdge(0, 0));

        while (!dfs.isEmpty()) {
            State state = dfs.pop();
            if (state.x == n - 1 && state.y == n - 1) return true;

            for (int[] direction: directions) {
                int x = state.x + direction[0];
                int y = state.y + direction[1];
                if (visited.contains(getEdge(x, y)) || !valid(n, x, y)) continue;
                if (grid[x][y] > time) continue;

                dfs.push(new State(x, y, Math.max(state.t, grid[x][y])));
                visited.add(getEdge(x, y));
            }
        }

        return false;
    }

    public boolean valid(int n, int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public String getEdge(int x, int y) {
        return String.valueOf(x) + "-" + String.valueOf(y);
    }
}