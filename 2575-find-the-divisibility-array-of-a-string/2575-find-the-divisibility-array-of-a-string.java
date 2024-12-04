class Solution {
    public int[] divisibilityArray(String word, int m) {
        int[] result = new int[word.length()];
        long remainder = 0;

        for (int i = 0; i < word.length(); i++) {
            int digit = word.charAt(i) - '0';
            remainder = (remainder * 10 + digit) % m;
            result[i] = (remainder == 0) ? 1 : 0;
        }

        return result;
    }
}