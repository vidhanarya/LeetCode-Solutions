class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] minPrefix = new int[n];
        
        minPrefix[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            minPrefix[i] = Math.min(minPrefix[i+1], arr[i]);
        }

        int currMax = arr[0], chunks = 1;
        for (int i = 1; i < n; i++) {
            if (currMax <= minPrefix[i]) chunks++;
            currMax = Math.max(arr[i], currMax);
        }

        return chunks;
    }
}