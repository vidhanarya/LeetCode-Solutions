class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        List<List<Integer>> heights = new ArrayList<>(101);
        for (int i = 0; i < 101; i++) heights.add(new ArrayList<>());

        Arrays.sort(rectangles, Comparator.comparingInt(a -> a[0]));
        for (int[] rectangle: rectangles) {
            heights.get(rectangle[1]).add(rectangle[0]);
        }

        int[] result = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            result[i] = getCount(heights, points[i][0], points[i][1]);
        }

        return result;
    }

    public int getCount(List<List<Integer>> rectangles, int l, int h) {
        int count = 0;
        for (int i = h; i <= 100; i++) {
            if (rectangles.get(i).isEmpty()) continue;

            int left = 0, right = rectangles.get(i).size();
            while (left < right) {
                int mid = left + (right - left) / 2;

                if (rectangles.get(i).get(mid) >= l) right = mid;
                else left = mid + 1;
            }

            count += rectangles.get(i).size() - left;
        }

        return count;
    }
}