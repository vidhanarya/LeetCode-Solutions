class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] isReachable = new boolean[numCourses][numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            graph.get(b).add(a);
        }

        for (int i = 0; i < numCourses; i++) {
            Queue<Integer> bfs = new LinkedList<>();
            bfs.offer(i);

            while (!bfs.isEmpty()) {
                int node = bfs.poll();
                
                for (int child : graph.get(node)) {
                    if (isReachable[i][child]) continue;

                    bfs.offer(child);
                    isReachable[i][child] = true;
                }
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            result.add(isReachable[queries[i][1]][queries[i][0]]);
        }

        return result;
    }
}