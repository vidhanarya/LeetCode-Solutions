class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];
        
        for (int[] relation : relations) {
            int prev = relation[0]-1;
            int next = relation[1]-1;

            graph.computeIfAbsent(prev, _ -> new ArrayList<>()).add(next);
            indegree[next]++;
        }

        int[] timeTaken = new int[n];
        Queue<Integer> bfs = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                bfs.offer(i);
            }
        }

        int totalTimeTaken = 0;
        while (!bfs.isEmpty()) {
            int course = bfs.poll();
            totalTimeTaken = Math.max(totalTimeTaken, timeTaken[course] + time[course]);

            for (int next : graph.getOrDefault(course, new ArrayList<>())) {
                timeTaken[next] = Math.max(timeTaken[next], timeTaken[course] + time[course]);
                indegree[next]--;
                if (indegree[next] == 0) {
                    bfs.offer(next);
                }
            }
        }

        return totalTimeTaken;
    }
}