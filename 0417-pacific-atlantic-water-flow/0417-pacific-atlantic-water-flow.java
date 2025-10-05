class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<String> pacificIslands = new HashSet<>();
        Set<String> atlanticIslands = new HashSet<>();

        for (int i = 0; i < heights.length; i++) {
            String key = getKey(i, 0);
            if (pacificIslands.contains(key)) continue;

            bfs(heights, pacificIslands, i, 0);
        }

        for (int i = 0; i < heights[0].length; i++) {
            String key = getKey(0, i);
            if (pacificIslands.contains(key)) continue;

            bfs(heights, pacificIslands, 0, i);
        }

        for (int i = 0; i < heights.length; i++) {
            String key = getKey(i, heights[0].length-1);
            if (atlanticIslands.contains(key)) continue;

            bfs(heights, atlanticIslands, i, heights[0].length-1);
        }

        for (int i = 0; i < heights[0].length; i++) {
            String key = getKey(heights.length-1 , i);
            if (atlanticIslands.contains(key)) continue;

            bfs(heights, atlanticIslands, heights.length-1, i);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                String key = getKey(i, j);
                if (pacificIslands.contains(key) && atlanticIslands.contains(key)) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    private void bfs(int[][] heights, Set<String> visited, int x, int y) {
        Queue<Pair<Integer, Integer>> bfs = new ArrayDeque<>();
        bfs.add(new Pair<>(x, y));
        visited.add(getKey(x, y));

        while (!bfs.isEmpty()) {
            Pair<Integer, Integer> node = bfs.poll();
            
            for (int[] direction : directions) {
                int i = node.getKey() + direction[0];
                int j = node.getValue() + direction[1];
                String key = getKey(i, j);

                if (!isValid(heights.length, heights[0].length, i, j)) continue;
                if (visited.contains(key)) continue;
                if (heights[node.getKey()][node.getValue()] > heights[i][j]) continue;

                visited.add(key);
                bfs.offer(new Pair<>(i, j));
            }
        }
    }

    private String getKey(int i, int j) {
        return String.valueOf(i) + ":" + String.valueOf(j);
    }

    private boolean isValid(int n, int m, int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
}