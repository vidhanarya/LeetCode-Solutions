class State {
    int x;
    int y;
    int change;

    State(int x, int y, int change) {
        this.x = x;
        this.y = y;
        this.change = change;
    }
}

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Map<String, Integer> visited = new HashMap<>();

        PriorityQueue<State> bfs = new PriorityQueue<>(Comparator.comparingInt(a -> a.change));
        bfs.offer(new State(0, 0, 0));

        while (!bfs.isEmpty()) {
            State state = bfs.poll();
            if (state.x == m-1 && state.y == n-1) return state.change;

            for (int i = 1; i <= 4; i++) {
                int[] direction = directions[i-1];
                int newX = state.x + direction[0];
                int newY = state.y + direction[1];
                int newChange = (i == grid[state.x][state.y]) ? state.change : state.change + 1;

                if (newX < 0 || newX >= m || newY < 0 || newY >= n) continue;
                if (visited.getOrDefault(newX + ", " + newY, Integer.MAX_VALUE) <= newChange) continue;

                visited.put(newX + ", " + newY, newChange);
                bfs.offer(new State(newX, newY, newChange));
            }
        }

        return -1;
    }
}