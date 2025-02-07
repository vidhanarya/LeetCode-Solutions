class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> colorFreq = new HashMap<>();
        Map<Integer, Integer> ballToColor = new HashMap<>();
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int ball = query[0], newColor = query[1];
            int existingColor = ballToColor.getOrDefault(ball, 0);
            int existingColorFreq = colorFreq.getOrDefault(existingColor, 0);
            if (existingColor == newColor) continue;

            if (existingColor != 0 && existingColorFreq > 1) {
                colorFreq.put(existingColor, existingColorFreq-1);
            } else if (existingColor != 0 && existingColorFreq == 1) {
                colorFreq.remove(existingColor);
            }

            colorFreq.put(newColor, colorFreq.getOrDefault(newColor, 0) + 1);
            ballToColor.put(ball, newColor);

            result[i] = colorFreq.size();
        }

        return result;
    }
}