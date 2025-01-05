class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] prefix = new int[s.length()];
        for (int i = 0; i < shifts.length; i++) {
            int start = shifts[i][0], end = shifts[i][1];
            int diff = (shifts[i][2] == 1) ? 1 : -1;

            prefix[start] += diff;
            if (end < s.length() - 1) prefix[end+1] -= diff;
        }

        char[] shiftString = s.toCharArray();
        for (int i = 0; i < prefix.length; i++) {
            if (i > 0) prefix[i] += prefix[i-1];

            int c = (shiftString[i] - 'a' + prefix[i]) % 26;
            if (c < 0) c += 26;

            shiftString[i] = (char) (c + 'a');
        }

        return new String(shiftString);
    }
}

// prefix = [-1, 2, -1, 0]