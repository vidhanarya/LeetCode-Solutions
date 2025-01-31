class Island {
    int id;
    int size;

    Island(int id, int size) {
        this.id = id;
        this.size = size;
    }
}

class Solution {
    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        
        List<Island> islandList = new ArrayList<>();
        Map<String, Set<Integer>> connectingIslands = new HashMap<>();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || grid[i][j] == 0) continue;

                Island currIsland = new Island(islandList.size(), 1);
                islandList.add(currIsland);

                Queue<Pair<Integer, Integer>> bfs = new LinkedList<>();
                bfs.offer(new Pair<>(i, j));
                visited[i][j] = true;

                while (!bfs.isEmpty()) {
                    Pair<Integer, Integer> idxPair = bfs.poll();
                    int x = idxPair.getKey(), y = idxPair.getValue();

                    for (int[] direction: directions) {
                        int p = x + direction[0];
                        int q = y + direction[1];

                        if (p < 0 || p >= m || q < 0 || q >= n || visited[p][q]) continue;
                        connectingIslands.computeIfAbsent(p+","+q, k -> new HashSet<>()).add(currIsland.id);

                        if (grid[p][q] == 1) {
                            bfs.offer(new Pair<>(p, q));
                            visited[p][q] = true;
                            currIsland.size++;
                        }
                    }
                }
            }
        }

        int maxIslandSize = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int currIslandSize = 0;
                for (int islandId: connectingIslands.getOrDefault(i+","+j, new HashSet<>())) {
                    currIslandSize += islandList.get(islandId).size;
                }
                currIslandSize += 1 - grid[i][j];
                maxIslandSize = Math.max(maxIslandSize, currIslandSize);
            }
        }

        return maxIslandSize;
    }
}