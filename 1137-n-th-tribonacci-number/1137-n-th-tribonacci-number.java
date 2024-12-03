class Solution {
    public int tribonacci(int n) {
        int[] tri = new int[]{0, 1, 1};
        if (n <= 2) return tri[n];

        for (int i = 3; i <= n; i++) {
            int temp = tri[2];
            tri[2] = tri[0] + tri[1] + tri[2];
            tri[0] = tri[1];
            tri[1] = temp;
        }

        return tri[2];
    }
}