class Solution {
    int[] memo;

    public int deleteString(String s) {
        memo = new int[s.length()];
        memo[s.length()-1] = 1;

        return dp(s, 0);
    }

    public int dp(String s, int start) {
        if (memo[start] > 0) return memo[start];

        List<Integer> wps = new ArrayList<>();
        wps.add(start);

        int result = 1;
        for (int i = start, j = start+1; j < s.length(); j++) {
            if (s.charAt(i) == s.charAt(j)) {
                wps.add(++i);
            } else if (i > start) {
                i = wps.get(i-start-1);
                j--;
                continue;
            } else {
                wps.add(start);
            }

            if (2 * (wps.getLast() - start) == wps.size()) {
                result = Math.max(result, 1 + dp(s, i));
            }
        }

        memo[start] = result;
        return result;
    }
}

// aaabaab
// [1, 2, 1, 2, 3, 4]
// [0, 1, 0, 1, 2, 3]
