class Solution {
    public long maximumTotalDamage(int[] power) {
        List<Integer> uniquePower = new ArrayList<>();
        List<Long> sortedPower = new ArrayList<>();
        Arrays.sort(power);

        sortedPower.add((long) power[0]);
        uniquePower.add(power[0]);
        for (int i = 1; i < power.length; i++) {
            if (power[i] == power[i-1]) {
                sortedPower.set(sortedPower.size()-1, sortedPower.getLast()+power[i]);
            } else {
                uniquePower.add(power[i]);
                sortedPower.add((long) power[i]);
            }
        }
        
        int n = uniquePower.size();
        for (int i = n-1; i >= 0; i--) {
            if (i+2 < n && uniquePower.get(i) + 2 == uniquePower.get(i+2)) {
                if (i+3 < n) {
                    sortedPower.set(i, Math.max(sortedPower.get(i) + sortedPower.get(i+3), Math.max(sortedPower.get(i+1), sortedPower.get(i+2))));
                } else {
                    sortedPower.set(i, Math.max(sortedPower.get(i), Math.max(sortedPower.get(i+1), sortedPower.get(i+2))));
                }
            } else if (i+1 < n && uniquePower.get(i) + 2 >= uniquePower.get(i+1)) {
                if (i+2 < n) {
                    sortedPower.set(i, Math.max(sortedPower.get(i) + sortedPower.get(i+2), sortedPower.get(i+1)));
                } else {
                    sortedPower.set(i, Math.max(sortedPower.get(i), sortedPower.get(i+1)));
                }
            } else if (i+1 < n && uniquePower.get(i) + 2 < uniquePower.get(i+1)) {
                sortedPower.set(i, sortedPower.get(i) + sortedPower.get(i+1));
            }
        }

        return sortedPower.get(0);
    }
}