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

    public int maximumMinutes(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] fire = new int[n][m];
        propagateFire(grid, fire, n, m);

        int left = -1, right = 1000000000;
        while (left < right) {
            int mid = right - (right - left) / 2;

            if (canPass(grid, fire, n, m, mid)) left = mid;
            else right = mid - 1;
        }

        return right;
    }

    public boolean canPass(int[][] grid, int[][] fire, int n, int m, int time) {
        Queue<State> bfsMan = new LinkedList<>();
        Set<String> visitedMan = new HashSet<>();
        bfsMan.offer(new State(0, 0, 0));
        visitedMan.add(edge(0, 0));

        while (!bfsMan.isEmpty()) {
            State state = bfsMan.poll();
            if (state.x == n - 1 && state.y == m - 1) return true;

            for (int[] direction: directions) {
                int x = state.x + direction[0];
                int y = state.y + direction[1];
                if (!valid(n, m, x, y) || visitedMan.contains(edge(x, y))) continue;
                if (grid[x][y] != 0 || fire[x][y] <= time + state.t + 1) continue;

                visitedMan.add(edge(x, y));
                bfsMan.offer(new State(x, y, state.t + 1));
            }
        }

        return false;
    }

    public void propagateFire(int[][] grid, int[][] fire, int n, int m) {
        Queue<State> bfsFire = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                fire[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 1) continue;
                bfsFire.offer(new State(i, j, 0));
                fire[i][j] = 0;
            }
        }

        while (!bfsFire.isEmpty()) {
            State state = bfsFire.poll();

            for (int[] direction: directions) {
                int x = state.x + direction[0];
                int y = state.y + direction[1];
                if (!valid(n, m, x, y) || fire[x][y] != Integer.MAX_VALUE || grid[x][y] == 2) continue;

                int t = (x == n - 1 && y == m - 1) ? state.t + 2 : state.t + 1;
                bfsFire.offer(new State(x, y, t));
                fire[x][y] = t;
            }
        }
    }

    public boolean valid(int n, int m, int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }

    public String edge(int x, int y) {
        return x + ", " + y;
    }
}