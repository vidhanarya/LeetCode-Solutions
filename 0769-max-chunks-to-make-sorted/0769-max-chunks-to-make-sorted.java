class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int currMax = arr[0], chunks = 0;

        for (int i = 0; i < n; i++) {
            currMax = Math.max(arr[i], currMax);
            if (currMax == i) chunks++;
        }

        return chunks;
    }
}