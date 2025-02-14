class Solution {
    public String minWindow(String s, String t) {
        int[] freqT = new int[100];
        for (int i = 0; i < t.length(); i++) {
            freqT[t.charAt(i) - 'A']++;
        }

        int left = 0, remainingChars = t.length();
        int minLeft = 0, minRight = Integer.MAX_VALUE;
        int[] freqCurrent = new int[100];
        for (int right = 0; right < s.length(); right++) {
            int rightChar = s.charAt(right) - 'A';
            if (freqCurrent[rightChar] < freqT[rightChar]) {
                remainingChars--;
            }

            freqCurrent[rightChar]++;
            while (remainingChars <= 0 && left <= right) {
                if (right - left < minRight - minLeft) {
                    minLeft = left;
                    minRight = right;
                }

                int leftChar = s.charAt(left) - 'A';
                freqCurrent[leftChar]--;
                if (freqCurrent[leftChar] < freqT[leftChar]) {
                    remainingChars++;
                }

                left++;
            }
        }

        return (minRight > s.length()) ? "" : s.substring(minLeft, minRight+1);
    }
}