class Solution {
    public long repairCars(int[] ranks, int cars) {
        long min = 1, max = 1L * ranks[0] * cars * cars;
        while (min < max) {
            long mid = min + (max - min) / 2;

            long repaired = 0;
            for (int i = 0; i < ranks.length; i++) {
                repaired += (long) Math.sqrt((1.0 * mid) / ranks[i]);
            }

            if (repaired >= cars) max = mid;
            else min = mid+1;
        }

        return min;
    }
}