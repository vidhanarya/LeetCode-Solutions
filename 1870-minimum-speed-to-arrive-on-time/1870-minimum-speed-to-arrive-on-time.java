class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1, right = 10000001;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (check(dist, hour, mid)) right = mid;
            else left = mid + 1;
        }

        return (left == 10000001) ? -1 : left;
    }

    public boolean check(int[] dist, double limit, int speed) {
        double time = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            time += Math.ceil(dist[i] / (double) speed);
            if (time >= limit) return false;
        }

        time += dist[dist.length - 1] / (double) speed;
        return (time <= limit);
    }
}