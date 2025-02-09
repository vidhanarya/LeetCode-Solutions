class Solution {
    public int consecutiveNumbersSum(int n) {
        int result = 1, p = 2;

        while (n >= (p * (p+1)) / 2) {
            if ((n - (p * (p - 1)) / 2) % p == 0) {
                result++;
            }
            p++;
        }

        return result;
    }
}

// x1 + x1+1 + x1+2 .... x1+p-1 = n
// x1 = [n - p*(p-1)/2] / p
// 3 + (1 + 2 + 3)