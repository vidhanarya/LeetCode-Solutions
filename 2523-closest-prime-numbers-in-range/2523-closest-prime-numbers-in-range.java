class Solution {
    public int[] closestPrimes(int left, int right) {
        int num1 = -1, num2 = -1;
        int[] result = new int[]{-1, -1};
        for (int n = left; n <= right; n++) {
            if (isPrime(n)) {
                num1 = num2;
                num2 = n;
            }

            if (num1 == -1 || num2 == -1) continue;
            if (result[0] == -1 || result[1] - result[0] > num2 - num1) {
                result[0] = num1;
                result[1] = num2;
            }
        }

        return result;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        
        for (int i = 5; i <= Math.sqrt(n); i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}
