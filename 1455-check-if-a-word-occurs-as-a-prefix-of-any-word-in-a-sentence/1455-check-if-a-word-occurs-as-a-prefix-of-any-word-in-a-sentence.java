class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int i = 0;
        int wordIdx = 0;
        while (i < sentence.length()) {
            if (i == 0 || sentence.charAt(i-1) == ' ') {
                wordIdx++;
                if (isPrefixed(sentence, searchWord, i)) return wordIdx;
            }
            i++;
        }

        return -1;
    }

    public boolean isPrefixed(String sentence, String searchWord, int i) {
        int j = 0;
        while (i < sentence.length() && sentence.charAt(i) != ' ') {
            if (j == searchWord.length()) return true;
            if (sentence.charAt(i) != searchWord.charAt(j)) return false;
            if (sentence.charAt(i) == searchWord.charAt(j)) j++;
            i++;
        }

        return j == searchWord.length();
    }
}