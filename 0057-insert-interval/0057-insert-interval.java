class Solution {
    List<int[]> result;

    public int[][] insert(int[][] intervals, int[] newInterval) {
        result = new ArrayList<>();
        boolean insertNew = true;
        for (int[] interval: intervals) {
            if (interval[0] >= newInterval[0] && insertNew) {
                addInterval(newInterval);
                insertNew = false;
            }

            addInterval(interval);
        }
        if (insertNew) addInterval(newInterval);

        return result.toArray(new int[result.size()][]);
    }

    public void addInterval(int[] interval) {
        if (result.isEmpty() || interval[0] > result.getLast()[1]) {
            result.add(interval);
            return;
        }

        result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
    }
}