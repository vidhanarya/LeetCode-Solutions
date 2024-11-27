class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int distance = 0;
        for (int i = 0; i < nums2.length; i++) {
            int n = nums2[i];
            int l1 = 0, r1 = Math.min(i, nums1.length - 1);
            while (l1 < r1) {
                int m1 = l1 + (r1 - l1) / 2;

                if (nums1[m1] <= n) r1 = m1;
                else l1 = m1 + 1;
            }

            if (nums1[l1] <= n) {
                distance = Math.max(distance, i - l1);
            }
        }
        return distance;
    }
}