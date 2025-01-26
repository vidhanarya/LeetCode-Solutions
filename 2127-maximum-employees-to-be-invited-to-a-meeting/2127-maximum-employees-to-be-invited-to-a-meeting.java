class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            indegree[favorite[i]]++;
        }

        Queue<Integer> bfs = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                bfs.offer(i);
            }
        }

        int[] chainLens = new int[n];
        Arrays.fill(chainLens, 1);
        while (!bfs.isEmpty()) {
            int node = bfs.poll();
            int child = favorite[node];

            chainLens[child] = Math.max(chainLens[child], chainLens[node] + 1);
            if (--indegree[child] == 0) {
                bfs.offer(child);
            }
        }

        int longestCycle = 0, twoPersonCycle = 0;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) continue;

            int cycleLen = 0;
            int curr = i;
            while (indegree[curr] != 0) {
                indegree[curr]--;
                cycleLen++;
                curr = favorite[curr];
            }

            if (cycleLen == 2) {
                twoPersonCycle += chainLens[i] + chainLens[favorite[i]];
            } else {
                longestCycle = Math.max(longestCycle, cycleLen);
            }
        }

        return Math.max(longestCycle, twoPersonCycle);
    }
}