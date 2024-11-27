class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        char[] zigzag = new char[s.length()];

        int idx = 0, row = 0;
        while (idx < s.length() && row < numRows) {
            boolean dirUp = (row >= numRows - 1);
            int ptr = row;
            while (ptr < s.length()) {
                zigzag[idx++] = s.charAt(ptr);

                ptr += (dirUp) ? 2 * row : 2 * (numRows - 1 - row);

                if (row == 0 || row == numRows - 1) continue;
                dirUp = !dirUp;
            }
            row++;
        }

        return new String(zigzag);
    }
}