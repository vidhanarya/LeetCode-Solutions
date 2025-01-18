class Solution {
    Map<String, Boolean> dp = new HashMap<>();

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordMap.put(words[i], wordMap.getOrDefault(words[i], 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        int wordLen = words[0].length();
        int permutationLen = words.length * wordLen;
        for (int i = 0; i < s.length() - permutationLen + 1; i++) {
            if (isPermutation(wordMap, s.substring(i, i + permutationLen), wordLen)) {
                result.add(i);
            }
        }

        return result;
    }

    public boolean isPermutation(Map<String, Integer> wordMap, String s, int wordLen) {
        if (dp.containsKey(s)) return dp.get(s);

        int start = 0;
        Map<String, Integer> seen = new HashMap<>();
        while (start < s.length()) {
            String currWord = s.substring(start, start + wordLen);
            seen.put(currWord, seen.getOrDefault(currWord, 0) + 1);

            if (seen.get(currWord) > wordMap.getOrDefault(currWord, 0)) {
                dp.put(s, false);
                return false;
            }

            start += wordLen;
        }

        dp.put(s, true);
        return true;
    }
}