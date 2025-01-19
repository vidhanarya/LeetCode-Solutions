class Solution {
    public int minNumberOperations(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> target[a]));
        for (int i = 0; i < target.length; i++) {
            pq.offer(i);
        }

        Set<Integer> edges = new HashSet<>();
        edges.add(-1);
        edges.add(target.length);

        int parts = 1, start = 0, operations = 0;
        while (!pq.isEmpty()) {
            int x = pq.poll();
            if (target[x] > start) {
                operations += parts * (target[x] - start);
                start = target[x];
            }

            if (!(edges.contains(x+1) || edges.contains(x-1))) {
                parts++;
            } else if (edges.contains(x+1) && edges.contains(x-1)) {
                parts--;
            }
            edges.add(x);
        }

        return operations;
    }
}