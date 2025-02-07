class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] dep : prerequisites) {
            indegree[dep[0]]++;
            graph.computeIfAbsent(dep[1], _ -> new ArrayList<>()).add(dep[0]);
        }

        Queue<Integer> bfs = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                bfs.offer(i);
            }
        }
        
        List<Integer> order = new ArrayList<>();
        while (!bfs.isEmpty()) {
            int course = bfs.poll();
            order.add(course);

            for (int dep : graph.getOrDefault(course, new ArrayList<>())) {
                indegree[dep]--;
                if (indegree[dep] == 0) {
                    bfs.offer(dep);
                }
            }
        }

        if (order.size() != numCourses) return new int[0];
        int[] courses = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = order.get(i);
        }

        return courses;
    }
}
