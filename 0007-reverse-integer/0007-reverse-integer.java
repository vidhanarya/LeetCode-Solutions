class Solution {
    public int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE) return 0;
        if (x < 0) return -1 * reverse(-x);

        if (!validate(x)) return 0;
        return reverseInt(x);
    }

    private boolean validate(int x) {
        int m = Integer.MAX_VALUE;
        int d = 1_000_000_000;
        int e = 1;
        if (x / d == 0) return true;

        while (d > 0) {
            int left = (m / d) % 10;
            int right = (x / e) % 10;
            if (left < right) return false;
            if (left > right) return true;

            d /= 10;
            e *= 10;
        }
        return true;
    }

    private int reverseInt(int x) {
        int d = 1_000_000_000;
        while (x / d == 0) d /= 10;
        
        int m = 1;
        int r = 0;
        while (d > 0) {
            r += d * ((x / m) % 10);
            d /= 10;
            m *= 10;
        }

        return r;
    }
}