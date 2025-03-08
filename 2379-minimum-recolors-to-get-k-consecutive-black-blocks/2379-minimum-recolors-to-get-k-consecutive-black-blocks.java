class Solution {
    public int minimumRecolors(String blocks, int k) {
        int countW = 0, minCount = k;
        for (int i = 0; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') countW++;
            if (i < k-1) continue; 
            if (i >= k && blocks.charAt(i-k) == 'W') {
                countW--;
            }

            minCount = Math.min(minCount, countW);
        }

        return minCount;
    }
}