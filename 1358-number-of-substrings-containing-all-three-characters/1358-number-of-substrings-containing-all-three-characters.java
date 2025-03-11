class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] freq = new int[3];
        int left = 0, count = 0, numChars = 0;
        for (int right = 0; right < n; right++) {
            freq[s.charAt(right) - 'a']++;
            if (freq[s.charAt(right) - 'a'] == 1) {
                numChars++;
            }

            while (numChars == 3 ) {
                count += n - right;
                freq[s.charAt(left) - 'a']--;
                if (freq[s.charAt(left) - 'a'] == 0) {
                    numChars--;
                }
                left++;
            }
        }

        return count;
    }
}