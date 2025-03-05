class Solution {
    public long coloredCells(int n) {
        return 2L*n - 1 + 2L*(n-1L)*(n-1L);
    }
}
