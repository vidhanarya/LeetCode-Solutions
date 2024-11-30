class State {
    int from;
    int to;

    State(int from, int to) {
        this.from = from;
        this.to = to;
    }
}

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();

        for (int i = 0; i < pairs.length; i++) {
            graph.computeIfAbsent(pairs[i][0], a -> new LinkedList<>()).offerLast(pairs[i][1]);
            outdegree.put(pairs[i][0], outdegree.getOrDefault(pairs[i][0], 0) + 1);
            indegree.put(pairs[i][1], outdegree.getOrDefault(pairs[i][1], 0) + 1);
        }

        int startNode = pairs[0][0];
        for (int node: outdegree.keySet()) {
            if (outdegree.get(node) == indegree.getOrDefault(node, 0) + 1) {
                startNode = node;
                break;
            }
        }

        int[][] result = new int[pairs.length][2];
        Stack<State> dfs = new Stack<>();
        dfs.push(new State(startNode, graph.get(startNode).removeFirst()));

        int ptr = pairs.length - 1;
        while (!dfs.empty() && ptr >= 0) {
            State state = dfs.peek();
            if (graph.getOrDefault(state.to, new LinkedList<>()).isEmpty()) {
                result[ptr][0] = state.from;
                result[ptr][1] = state.to;
                ptr--;
                dfs.pop();
                continue;
            }

            LinkedList<Integer> neighbours = graph.get(state.to);
            while (!neighbours.isEmpty()) {
                State newState = new State(state.to, neighbours.removeFirst());
                dfs.push(newState);
            }
        }

        return result;
    }
}