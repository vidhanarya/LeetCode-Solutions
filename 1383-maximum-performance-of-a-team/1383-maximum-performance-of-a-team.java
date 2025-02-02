class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = 1_000_000_007;

        List<Pair<Integer, Integer>> sortedList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sortedList.add(new Pair<>(efficiency[i], speed[i]));
        }

        sortedList.sort(Comparator.comparingInt(p -> -p.getKey()));
        PriorityQueue<Integer> speedHeap = new PriorityQueue<>();

        long speedSum = 0, perf = 0;
        for (Pair<Integer, Integer> pair : sortedList) {
            int currEfficiency = pair.getKey();
            int currSpeed = pair.getValue();
            if (speedHeap.size() > k-1) {
                speedSum -= speedHeap.poll();
            }
            speedHeap.add(currSpeed);
            speedSum += currSpeed;

            perf = Math.max(perf, speedSum * currEfficiency);
        }

        return (int) (perf % MOD);
    }
}
