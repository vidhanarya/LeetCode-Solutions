class Solution {
    public long findMaximumElegance(int[][] items, int k) {
        Arrays.sort(items, Comparator.comparingInt(a -> -a[0]));
        Set<Integer> included = new HashSet<>();
        PriorityQueue<Integer> replacable = new PriorityQueue<>();

        long elegance = 0;
        for (int i = 0; i < k; i++) {
            elegance += items[i][0];
            if (!included.contains(items[i][1])) {
                elegance += 2 * included.size() + 1;
            } else {
                replacable.offer(items[i][0]);
            }

            included.add(items[i][1]);
        }

        long maxElegance = elegance;
        for (int i = k; i < items.length; i++) {
            if (included.contains(items[i][1])) continue;
            if (replacable.isEmpty()) {
                return maxElegance;
            }

            elegance += (items[i][0] + 2 * included.size() + 1 - replacable.poll());
            included.add(items[i][1]);

            maxElegance = Math.max(maxElegance, elegance);
        }

        return maxElegance;
    }
}
