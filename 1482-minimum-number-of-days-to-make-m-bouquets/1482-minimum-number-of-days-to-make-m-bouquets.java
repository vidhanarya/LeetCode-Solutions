class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int left = 0, right = 1000000001;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (check(bloomDay, m, k, mid)) right = mid;
            else left = mid + 1; 
        }

        return (left == 1000000001) ? -1 : left;
    }

    public boolean check(int[] bloomDay, int m, int k, int minDays) {
        int bouquets = 0;
        int flowerCount = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= minDays) flowerCount++;
            else flowerCount = 0;

            if (flowerCount == k) {
                bouquets++;
                flowerCount = 0;
            }
        }


        return (bouquets >= m);
    }
}