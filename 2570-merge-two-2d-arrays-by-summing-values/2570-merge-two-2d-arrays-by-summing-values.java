class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] <= nums2[j][0]) add(merged, nums1[i++]);
            else add(merged, nums2[j++]);
        }

        while (i < nums1.length) {
            add(merged, nums1[i++]);
        }

        while (j < nums2.length) {
            add(merged, nums2[j++]);
        }

        return merged.toArray(new int[0][0]);
    }

    private void add(List<int[]> merged, int[] entry) {
        if (!merged.isEmpty() && merged.getLast()[0] == entry[0]) {
            merged.getLast()[1] += entry[1];
        } else {
            merged.add(new int[]{entry[0], entry[1]});
        }
    }
}