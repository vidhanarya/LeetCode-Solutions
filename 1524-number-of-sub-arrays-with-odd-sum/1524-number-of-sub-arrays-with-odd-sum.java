class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1_000_000_007;

        int prevOdd = 0, prevEven = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                prevEven = (prevEven + 1) % mod;
            } else {
                int newEven = prevOdd;
                int newOdd = prevEven + 1;
                prevOdd = newOdd % mod;
                prevEven = newEven % mod;
            }

            count = (count + prevOdd) % mod;
        }

        return count;
    }
}
