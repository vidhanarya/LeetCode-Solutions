class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int[] maxArray = new int[events.length];
        
        maxArray[events.length - 1] = events[events.length - 1][2];
        for (int i = events.length - 2; i >= 0; i--) {
            maxArray[i] = Math.max(maxArray[i+1], events[i][2]);
        }

        int result = 0;
        for (int i = 0; i < events.length; i++) {
            int value = events[i][2];
            int j = binarySearch(events, events[i][1] + 1, i + 1, events.length);
            if (j < events.length) {
                value += maxArray[j];
            }
            result = Math.max(result, value);
        }
        return result;
    }

    public int binarySearch(int[][] events, int target, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (events[mid][0] >= target) right = mid;
            else left = mid + 1;
        }

        return left;
    }
}