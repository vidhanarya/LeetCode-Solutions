class Solution {
    public int countPrimes(int n) {
        if (n < 2) return 0;

        boolean[] arr = new boolean[n];
        arr[0] = true;
        arr[1] = true;

        int r = (int) Math.sqrt(n)+1;
        for (int l = 2; l <= r; l++) {
            int m = 2;
            while (l*m < n) {
                arr[l*m] = true;
                m++;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!arr[i]) {
                count++;
            }
        }

        return count;
    }
}