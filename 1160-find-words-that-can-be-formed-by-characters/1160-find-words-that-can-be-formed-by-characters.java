class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charBank = new int[26];
        for (char c : chars.toCharArray()) {
            charBank[c-'a']++;
        }

        int goodStringLen = 0;
        for (String word : words) {
            if (isGoodString(charBank, word)) {
                goodStringLen += word.length();
            }
        }

        return goodStringLen;
    }

    private boolean isGoodString(int[] charBank, String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c-'a']++;
            if (freq[c-'a'] > charBank[c-'a']) {
                return false;
            }
        }

        return true;
    }
}