class State {
    int x;
    int y;
    int h;

    State(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
}

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<State> bfs = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    bfs.offer(new State(i, j, 0));
                    isWater[i][j] = 0;
                } else {
                    isWater[i][j] = -1;
                }
            }
        }

        while (!bfs.isEmpty()) {
            State state = bfs.poll();

            for (int[] direction : directions) {
                int x = state.x + direction[0];
                int y = state.y + direction[1];
                if (!valid(m, n, x, y) || isWater[x][y] != -1) continue;

                isWater[x][y] = state.h + 1;
                bfs.offer(new State(x, y, state.h + 1));
            }
        }

        return isWater;
    }

    public boolean valid(int m, int n, int x, int y) {
        return (x >= 0 && y >= 0 && x < m && y < n);
    }
}