class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] countingSort = new int[n+1];
        for (int citation: citations) {
            countingSort[Math.min(n, citation)]++;
        }

        int numPapers = 0;
        for (int i = n; i >= 0; i--) {
            numPapers += countingSort[i];
            
            if (numPapers >= i) {
                return i;
            }
        }

        return 0;
    }
}