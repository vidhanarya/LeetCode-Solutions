class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> roomUsage = new ArrayList<int[]>();
        for (int[] interval: intervals) {
            roomUsage.add(new int[]{interval[0], 1});
            roomUsage.add(new int[]{interval[1], -1});
        }

        Collections.sort(roomUsage, Comparator.comparingInt(a -> a[0]));
        int maxUsage = 0, currUsage = 0;
        for (int[] usage: roomUsage) {
            currUsage += usage[1];
            maxUsage = Math.max(currUsage, maxUsage);
        }
        return maxUsage;
    }
}