class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));

        int numCourses = 0, totalTime = 0;
        PriorityQueue<Integer> longestCourses = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < courses.length; i++) {
            if (courses[i][0] > courses[i][1]) continue;

            if (totalTime + courses[i][0] <= courses[i][1]) {
                numCourses++;
                totalTime += courses[i][0];
                longestCourses.offer(courses[i][0]);
            } else if (!longestCourses.isEmpty() && longestCourses.peek() > courses[i][0]) {
                totalTime += courses[i][0] - longestCourses.poll();
                longestCourses.offer(courses[i][0]);
            }
        }

        return numCourses;
    }
}