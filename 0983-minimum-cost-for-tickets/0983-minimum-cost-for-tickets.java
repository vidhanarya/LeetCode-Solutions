class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] search1 = getSearchArray(days, 1);
        int[] search7 = getSearchArray(days, 7);
        int[] search30 = getSearchArray(days, 30);

        int[] dp = new int[days.length];
        for (int i = days.length-1; i >= 0; i--) {
            int cost1 = (search1[i] != -1) ? dp[search1[i]] + costs[0] : costs[0];
            int cost7 = (search7[i] != -1) ? dp[search7[i]] + costs[1] : costs[1];
            int cost30 = (search30[i] != -1) ? dp[search30[i]] + costs[2] : costs[2];

            dp[i] = Math.min(cost1, Math.min(cost7, cost30));
        }

        return dp[0];
    }

    public int[] getSearchArray(int[] days, int pass) {
        int[] searchArray = new int[days.length];
        Arrays.fill(searchArray, -1);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < days.length; i++) {
            queue.offer(i);

            while (!queue.isEmpty() && days[i] >= days[queue.peek()] + pass) {
                searchArray[queue.poll()] = i;
            }
        }

        return searchArray;
    }
}