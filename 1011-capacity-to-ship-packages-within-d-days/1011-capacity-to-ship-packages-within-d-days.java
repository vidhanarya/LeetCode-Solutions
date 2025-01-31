class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = max(weights), right = sum(weights)+1;

        while (left < right) {
            int shipWeight = left + (right - left) / 2;

            if (canShip(weights, shipWeight, days)) right = shipWeight;
            else left = shipWeight+1;
        }

        return left;
    }

    public boolean canShip(int[] weights, int shipWeight, int days) {
        int numDays = 1, currWeight = 0;
        for (int w : weights) {
            if (w > shipWeight) return false;

            currWeight += w;
            if (currWeight > shipWeight) {
                currWeight = w;
                numDays++;
            }
        }

        return (numDays <= days);
    }

    public int max(int[] nums) {
        int m = 0;
        for (int n : nums) {
            m = Math.max(m, n);
        }

        return m;
    }

    public int sum(int[] nums) {
        int s = 0;
        for (int n : nums) {
            s += n;
        }

        return s;
    }
}