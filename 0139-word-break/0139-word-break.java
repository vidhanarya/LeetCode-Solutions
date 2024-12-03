class Solution {
    Set<String> wordBank;
    int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        wordBank = new HashSet<>(wordDict);  
        memo = new int[s.length()];
        Arrays.fill(memo, -1);

        return dp(s, s.length() - 1);
    }

    public boolean dp(String s, int i) {
        if (i < 0) return true;
        if (memo[i] != -1) return (memo[i] == 1);

        boolean ans = false;
        for (int j = i; j >= 0; j--) {
            if (!wordBank.contains(s.substring(j, i+1))) continue;
            ans = dp(s, j-1);
            if (ans) break;
        }

        memo[i] = (ans) ? 1 : 0;
        return ans;
    }
}