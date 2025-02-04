class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int m = matrix.length, n = matrix[0].length;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            int currLeft = 0, currRight = n;
            for (int j = 0; j < n; j++) {
                height[j] = (matrix[i][j] == '1') ? height[j]+1 : 0;
            }

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') left[j] = Math.max(left[j], currLeft);
                else {
                    left[j] = 0;
                    currLeft = j+1;
                }
            }

            for (int j = n-1; j >= 0; j--) {
                if (matrix[i][j] == '1') right[j] = Math.min(right[j], currRight);
                else {
                    right[j] = n;
                    currRight = j;
                }
            }

            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
            }
        }

        return maxArea;
    }
}