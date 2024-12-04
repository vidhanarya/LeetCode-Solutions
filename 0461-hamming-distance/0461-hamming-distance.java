class Solution {
    public int hammingDistance(int x, int y) {
        return countOneBits(x^y);
    }
    
    public int countOneBits(int n) {
        int numBits = 0;
        while (n > 0) {
            numBits++;
            n = n & (n - 1);
        }
        
        return numBits;
    }
}