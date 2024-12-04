class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int lastStop = 0;
        for (int[] trip: trips) lastStop = Math.max(lastStop, trip[2]);

        int[] passengerCount = new int[lastStop+1];
        for (int[] trip: trips) {
            passengerCount[trip[1]] += trip[0];
            passengerCount[trip[2]] -= trip[0];
        }

        for (int count: passengerCount) {
            capacity -= count;
            if (capacity < 0) return false;
        }
        return true;
    }
}