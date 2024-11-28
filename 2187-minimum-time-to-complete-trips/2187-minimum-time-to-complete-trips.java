class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);

        long left = 0, right = 100000000000001L;
        while (left < right) {
            long mid = left + (right - left) / 2;

            if (check(time, totalTrips, mid)) right = mid;
            else left = mid + 1;
        }

        return left;
    }

    public boolean check(int[] time, int totalTrips, long minTime) {
        long trips = 0;
        for (long t: time) {
            trips += minTime / t;
        }

        return (trips >= totalTrips);
    }
}