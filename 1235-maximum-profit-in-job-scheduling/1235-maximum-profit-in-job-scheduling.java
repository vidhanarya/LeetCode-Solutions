class Job {
    int start;
    int end;
    int profit;

    Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }

        jobs.sort((a, b) -> {
            if (a.start != b.start) return a.start - b.start;
            if (a.end != b.end) return a.end - b.end;
            return b.profit - a.profit;
        });

        int[] memo = new int[jobs.size()];
        Arrays.fill(memo, -1);

        return getMaxProfit(jobs, memo, 0);
    }

    public int getMaxProfit(List<Job> jobs, int[] memo, int idx) {
        if (idx >= jobs.size()) return 0;
        if (memo[idx] != -1) return memo[idx];

        int nextIdx = binarySearch(jobs, jobs.get(idx).end);
        int profitWhenIncluded = jobs.get(idx).profit + getMaxProfit(jobs, memo, nextIdx);
        int profitWhenExcluded = getMaxProfit(jobs, memo, idx + 1);

        memo[idx] = Math.max(profitWhenIncluded, profitWhenExcluded);
        return memo[idx];
    }

    public int binarySearch(List<Job> jobs, int target) {
        int left = 0, right = jobs.size();
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (jobs.get(mid).start >= target) right = mid;
            else left = mid + 1;
        }

        return left;
    }
}