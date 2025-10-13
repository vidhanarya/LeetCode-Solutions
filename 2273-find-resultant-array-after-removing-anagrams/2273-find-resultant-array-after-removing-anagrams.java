class Solution {
    public List<String> removeAnagrams(String[] words) {
        ArrayList<String> result = new ArrayList<>();
        for (String word : words) {
            if (!result.isEmpty() && isAnagram(word, result.getLast())) {
                continue;
            }
            result.add(word);
        }

        return result;
    }

    public boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] freq = new int[26];
        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : s2.toCharArray()) {
            freq[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }
}