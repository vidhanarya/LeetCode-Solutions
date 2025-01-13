class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];
        int finalLength = s.length();
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            freq[idx]++;
            if (freq[idx] > 2) {
                freq[idx] -= 2;
                finalLength -= 2;
            }
        }

        return finalLength;
    }
}