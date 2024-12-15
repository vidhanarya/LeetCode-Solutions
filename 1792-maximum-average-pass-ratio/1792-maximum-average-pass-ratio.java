class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
            int[] classA = classes[a];
            int[] classB = classes[b];

            double rA = (double) classA[0] / classA[1];
            double rB = (double) classB[0] / classB[1];

            double deltaA = (1.0 / (1.0 + classA[1])) * (1.0 - rA);
            double deltaB = (1.0 / (1.0 + classB[1])) * (1.0 - rB);

            return Double.compare(deltaB, deltaA);
        });

        for (int i = 0; i < classes.length; i++) {
            maxHeap.offer(i);
        }

        while (extraStudents > 0) {
            int idx = maxHeap.poll();
            classes[idx][0] += 1;
            classes[idx][1] += 1;

            maxHeap.offer(idx);
            extraStudents--;
        }

        double totalAverages = 0;
        for (int i = 0; i < classes.length; i++) {
            totalAverages += (double) classes[i][0] / classes[i][1];
        }

        return totalAverages / classes.length;
    }
}
