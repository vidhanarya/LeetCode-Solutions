class State {
    int n;
    int i;

    State(int n, int i) {
        this.n = n;
        this.i = i;
    }
}

class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> {
            if (a.n != b.n) return a.n - b.n;
            return a.i - b.i;
        });

        for (int i = 0; i < nums.length; i++) {
            pq.add(new State(nums[i], i));
        }

        long score = 0;
        boolean[] visited = new boolean[nums.length];

        while (!pq.isEmpty()) {
            State state = pq.poll();
            int num = state.n, idx = state.i;
            if (visited[idx]) continue;

            score += num;
            visited[idx] = true;
            if (idx - 1 >= 0) visited[idx-1] = true;
            if (idx + 1 < nums.length) visited[idx+1] = true;
        }

        return score;
    }
}