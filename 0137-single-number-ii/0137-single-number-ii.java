class Solution {
    public int singleNumber(int[] nums) {
        int loner = 0;

        for (int i = 0; i < 32; i++) {
            int lonerBit = 0;
            for (int n: nums) {
                lonerBit += ((n & (1 << i)) != 0) ? 1 : 0;
            }
            lonerBit = lonerBit % 3;
            loner = loner | (lonerBit << i);
        }

        return loner;
    }
}