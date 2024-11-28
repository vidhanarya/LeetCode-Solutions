class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);

        int left = 0, right = 1000000000;
        while (left < right) {
            int mid = right - (right - left) / 2;

            if (!check(price, k, mid)) right = mid - 1;
            else left = mid;
        }

        return left;
    }

    public boolean check(int[] price, int k, int t) {
        int basketSize = 0;
        int lastPrice = -1000000000;
        for (int p: price) {
            if (p - lastPrice < t) continue;
            basketSize++;
            lastPrice = p;
        }

        return (basketSize >= k);
    }
}