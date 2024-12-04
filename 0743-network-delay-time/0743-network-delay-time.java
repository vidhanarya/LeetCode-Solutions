class State {
    int node;
    int delay;

    State(int node, int delay) {
        this.node = node;
        this.delay = delay;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] delays = new int[n+1];
        List<int[]>[] graph = new ArrayList[n+1];
        Arrays.fill(delays, Integer.MAX_VALUE);

        for (int[] time: times) {
            if (graph[time[0]] == null) graph[time[0]] = new ArrayList<>();
            graph[time[0]].add(new int[]{time[1], time[2]});
        }

        PriorityQueue<State> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.delay));
        minHeap.offer(new State(k, 0));
        delays[k] = 0;

        while (!minHeap.isEmpty()) {
            State state = minHeap.poll();
            if (graph[state.node] == null) continue;

            for (int[] neighbour: graph[state.node]) {
                int newDelay = state.delay + neighbour[1];
                if (newDelay >= delays[neighbour[0]]) continue;

                delays[neighbour[0]] = newDelay;
                minHeap.offer(new State(neighbour[0], newDelay));
            }
        }

        int maxDelay = delays[1];
        for (int i = 1; i <= n; i++) {
            maxDelay = Math.max(delays[i], maxDelay);
        }

        return (maxDelay == Integer.MAX_VALUE) ? -1 : maxDelay;
    }
}