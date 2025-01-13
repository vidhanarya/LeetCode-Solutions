class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;

        int[] freq = new int[26];
        int oddChars = 0;
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            
            if (freq[s.charAt(i) - 'a'] % 2 == 0) oddChars--;
            else oddChars++;
        }

        return (oddChars <= k);
    }
}