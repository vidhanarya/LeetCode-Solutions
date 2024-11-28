class State {
    int x, y, o;

    State(int x, int y, int o) {
        this.x = x;
        this.y = y;
        this.o = o;
    }
}

class Solution {
    public int minimumObstacles(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        PriorityQueue<State> bfs = new PriorityQueue<>(Comparator.comparingInt(a -> a.o));
        Map<String, Integer> visited = new HashMap<>();

        bfs.offer(new State(0, 0, 0));
        visited.put(getEdge(0, 0), 0);

        while (!bfs.isEmpty()) {
            State state = bfs.poll();
            if (state.x == n - 1 && state.y == m - 1) return state.o;

            for (int[] direction: directions) {
                int newX = state.x + direction[0];
                int newY = state.y + direction[1];
                if (!valid(n, m, newX, newY)) continue;

                String edge = getEdge(newX, newY);
                int newO = state.o + grid[newX][newY];
                if (visited.getOrDefault(edge, Integer.MAX_VALUE) <= newO) continue;

                bfs.offer(new State(newX, newY, newO));
                visited.put(edge, newO);
            }
        }

        return -1;
    }

    public String getEdge(int x, int y) {
        return String.valueOf(x) + "-" + String.valueOf(y);
    }

    public boolean valid(int n, int m, int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
}