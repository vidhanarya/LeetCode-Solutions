class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int ans = Integer.MAX_VALUE;
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (i != n-1) {
                    int temp = matrix[i+1][j];
                    if (j > 0) temp = Math.min(temp, matrix[i+1][j-1]);
                    if (j < m-1) temp = Math.min(temp, matrix[i+1][j+1]);
                    matrix[i][j] += temp;
                }

                if (i == 0) ans = Math.min(ans, matrix[i][j]);
            }
        }

        return ans;
    }
}