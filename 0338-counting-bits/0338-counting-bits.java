class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];

        int ptr = 0;
        int power = 0;
        for (int i = 1; i <= n; i++) {
            if (i == Math.pow(2, power)) {
                ptr = 0;
                power++;
            }
            result[i] = 1 + result[ptr++];
        }

        return result;
    }
}