class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;
        int size = 1, last = colors[0];

        for (int i = 0; i < n + k - 1; i++) {
            int idx = i % n;

            if (colors[idx] == last) {
                size = 1;
                last = colors[idx];
                continue;
            }

            size++;
            if (size >= k) {
                count++;
            }

            last = colors[idx];
        }

        return count;
    }
}