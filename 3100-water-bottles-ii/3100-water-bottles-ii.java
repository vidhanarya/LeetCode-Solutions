class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        return numBottles + maxBottlesDrunkHelper(numBottles, numExchange);
    }

    public int maxBottlesDrunkHelper(int N, int e) {
        if (e > N) {
            return 0;
        }

        double r = getQuadraticRoot(1, 2*e-1, -2*N);
        int c = (int) r;

        int N1 = N - e*c - ((c * (c-1)) / 2) + c;
        int e1 = e+c;
        return c + maxBottlesDrunkHelper(N1, e1);
    }

    public double getQuadraticRoot(int a, int b, int c) {
        return (double) (Math.sqrt(b*b - 4*a*c) - b) / (2.0 * a);
    }
}

// Original = N
// First Run = [(numExchange + numExchange+1...numExchange+m-1) <= N] -> m bottles
// Second Run = [numExchange+m + numExchange+m+1....numExchange+m+p-1 <= m + numExchange+m-1] -> max 1 bottle                                     