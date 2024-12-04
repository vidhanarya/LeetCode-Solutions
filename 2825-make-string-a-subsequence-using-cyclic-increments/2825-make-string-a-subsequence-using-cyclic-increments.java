class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int p1 = 0, p2 = 0;
        while (p1 < str1.length() && p2 < str2.length()) {
            if (charDiff(str1.charAt(p1), str2.charAt(p2)) <= 1) p2++;
            p1++;
        }

        return (p2 == str2.length());
    }

    public int charDiff(char c1, char c2) {
        int diff = c2 - c1;
        return (diff + 26) % 26;
    }
}