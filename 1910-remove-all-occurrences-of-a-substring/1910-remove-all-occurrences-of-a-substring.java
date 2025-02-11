class Solution {
    public String removeOccurrences(String s, String part) {
        int[] lps = new int[part.length()];
        for (int i = 0, j = 1; j < part.length();) {
            if (part.charAt(j) == part.charAt(i)) lps[j++] = ++i;
            else if (i > 0) i = lps[i-1];
            else lps[j++] = 0;
        }

        Deque<Character> deque = new ArrayDeque<>();
        int[] patternIndexes = new int[s.length()+1];

        for (int sIdx = 0, pIdx = 0; sIdx < s.length(); sIdx++) {
            char currChar = s.charAt(sIdx);
            deque.addLast(currChar);

            if (part.charAt(pIdx) == currChar) {
                patternIndexes[deque.size()] = ++pIdx;
            } else {
                if (pIdx == 0) patternIndexes[deque.size()] = 0;
                else {
                    pIdx = lps[pIdx - 1];
                    sIdx--;
                    deque.removeLast();
                }
            }

            if (pIdx != part.length()) continue;

            for (int x = 0; x < part.length(); x++) {
                deque.removeLast();
            }
            pIdx = deque.isEmpty() ? 0 : patternIndexes[deque.size()];
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }
}
