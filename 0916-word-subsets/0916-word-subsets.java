class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];
        for (String word : words2) {
            int[] currFreq = new int[26];
            for (int i = 0; i < word.length(); i++) {
                currFreq[word.charAt(i) - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], currFreq[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (String word : words1) {
            int[] currFreq = new int[26];
            for (int i = 0; i < word.length(); i++) {
                currFreq[word.charAt(i) - 'a']++;
            }

            result.add(word);
            for (int i = 0; i < 26; i++) {
                if (currFreq[i] < maxFreq[i]) {
                    result.removeLast();
                    break;
                }
            }
        }

        return result;
    }
}