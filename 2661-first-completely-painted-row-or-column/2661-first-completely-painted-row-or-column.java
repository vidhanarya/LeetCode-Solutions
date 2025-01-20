class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Map<Integer, Pair<Integer, Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                indexMap.put(mat[i][j], new Pair<>(i, j));
            }
        }

        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i = 0; i < arr.length; i++) {
            Pair<Integer, Integer> indexPair = indexMap.get(arr[i]);
            int r = indexPair.getKey(), c = indexPair.getValue();

            rows[r]++;
            cols[c]++;

            if (rows[r] == n || cols[c] == m) {
                return i;
            }
        }

        return -1;
    }
}