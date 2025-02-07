class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] dep : prerequisites) {
            indegree[dep[1]]++;
            graph.computeIfAbsent(dep[0], _ -> new ArrayList<>()).add(dep[1]);
        }

        Queue<Integer> bfs = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                bfs.offer(i);
            }
        }

        int coursesTaken = 0;
        while (!bfs.isEmpty()) {
            int course = bfs.poll();
            coursesTaken++;

            for (int dependent : graph.getOrDefault(course, new ArrayList<>())) {
                indegree[dependent]--;
                if (indegree[dependent] == 0) {
                    bfs.offer(dependent);
                }
            }
        }

        return (coursesTaken == numCourses);
    }
}