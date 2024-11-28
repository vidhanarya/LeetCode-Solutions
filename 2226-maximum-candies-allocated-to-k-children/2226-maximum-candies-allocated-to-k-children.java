class Solution {
    public int maximumCandies(int[] candies, long k) {
        int left = 0, right = 10000001;
        while (left < right) {
            int mid = right - (right - left) / 2;

            if (check(candies, k, mid)) left = mid;
            else right = mid - 1;
        }

        return left;
    }

    public boolean check(int[] candies, long k, int c) {
        long numPiles = 0;
        for (int candy: candies) {
            numPiles += (long) candy / c;
        }

        return (numPiles >= k);
    }
}