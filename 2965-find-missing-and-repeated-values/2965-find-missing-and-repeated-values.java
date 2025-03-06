class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length, totalNums = grid.length * grid.length;        
        long a = totalNums * (totalNums + 1) / 2;
        long b = a * (2 * totalNums + 1) / 3;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a -= grid[i][j];
                b -= grid[i][j] * grid[i][j];
            }
        }

        b = b/a;
        return new int[]{(int) (b - a) / 2 , (int) (a + b) / 2};
    }
}