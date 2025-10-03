class Solution {
    public String longestPalindrome(String s) {
        String longestString = "";
        for (int i = 0; i < 2*s.length()-1; i++) {
            int l, r;
            if (i % 2 == 0) {
                l = i/2;
                r = i/2;
            } else {
                l = (i-1)/2;
                r = (i+1)/2;
            }

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (longestString.length() < r - l + 1) {
                    longestString = s.substring(l, r+1);
                }
                l--;
                r++;
            }
        }

        return longestString;
    }
}