class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n];
        for (int[] relation : relations) {
            graph[relation[0]-1].add(relation[1]-1);
            indegree[relation[1]-1]++;
        }

        Queue<int[]> bfs = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                bfs.add(new int[]{i, 1});
            }
        }

        int maxSemester = 1, numCourses = 0;
        while (!bfs.isEmpty()) {
            int[] course = bfs.poll();
            numCourses++;
            maxSemester = Math.max(maxSemester, course[1]);

            for (int dependent : graph[course[0]]) {
                indegree[dependent]--;
                if (indegree[dependent] == 0) {
                    bfs.offer(new int[]{dependent, course[1]+1});
                }
            }
        }

        if (numCourses < n) return -1;
        return maxSemester;
    }
}