class Solution {
    public int countPrimes(int n) {
        if (n < 2) return 0;

        boolean[] arr = new boolean[n];
        for (int l = 2; l*l <= n; l++) {
            int m = 2;
            while (l*m < n) {
                arr[l*m] = true;
                m++;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!arr[i]) {
                count++;
            }
        }

        return count;
    }
}