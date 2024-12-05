class State {
    int city;
    int price;
    int stops;

    State(int city, int price, int stops) {
        this.city = city;
        this.price = price;
        this.stops = stops;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Integer[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], _ -> new ArrayList<>()).add(new Integer[]{flight[1], flight[2]});
        }

        PriorityQueue<State> bfs = new PriorityQueue<>(Comparator.comparingInt(a -> a.price));
        bfs.offer(new State(src, 0, 0));

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);

        while (!bfs.isEmpty()) {
            State state = bfs.poll();
            if (state.stops > stops[state.city] || state.stops > k + 1) continue;
            if (state.city == dst) return state.price;

            stops[state.city] = state.stops;
            for (Integer[] flight : graph.getOrDefault(state.city, new ArrayList<>())) {
                bfs.offer(new State(flight[0], state.price + flight[1], state.stops + 1));
            }
        }

        return -1;
    }
}