class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int left = 1, right = 1000000001;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (check(sweetness, k, mid)) left = mid + 1;
            else right = mid - 1;
        }

        return right;
    }

    public boolean check(int[] sweetness, int k, int maxTotal) {
        int peices = 0;
        int currTotal = 0;
        for (int i = 0; i < sweetness.length; i++) {
            currTotal += sweetness[i];
            if (currTotal < maxTotal) continue;

            peices++;
            currTotal = 0;
        }

        return (peices >= k + 1);
    }
}