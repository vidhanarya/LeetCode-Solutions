class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= ans.getLast()[1]) {
                int[] last = ans.getLast();
                last[0] = Math.min(intervals[i][0], last[0]);
                last[1] = Math.max(intervals[i][1], last[1]);
            } else {
                ans.add(intervals[i]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}