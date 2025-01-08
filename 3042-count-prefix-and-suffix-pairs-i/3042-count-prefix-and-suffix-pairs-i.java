class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) count++;
            }
        }

        return count;
    }

    public boolean isPrefixAndSuffix(String subject, String target) {
        int s = subject.length(), t = target.length();
        if (t < s) return false;

        for (int i = 0; i < subject.length(); i++) {
            if (target.charAt(i) != subject.charAt(i) || target.charAt(t-s+i) != subject.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}