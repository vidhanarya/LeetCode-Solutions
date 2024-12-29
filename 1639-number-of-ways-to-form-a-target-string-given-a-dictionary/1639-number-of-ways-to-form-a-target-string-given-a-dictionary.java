class Solution {
    public int numWays(String[] words, String target) {
        final int MOD = 1_000_000_007;
        
        int wordLen = words[0].length();
        int targetLen = target.length();
        if (wordLen < targetLen) return 0;
        
        int[][] charFreq = new int[wordLen][26];
        for (String word: words) {
            for (int i = 0; i < wordLen; i++) {
                charFreq[i][word.charAt(i) - 'a']++;
            }
        }

        long[][] dp = new long[targetLen+1][wordLen+1];
        for (int w = 0; w < wordLen; w++) dp[0][w] = 1;

        for (int t = 1; t <= targetLen; t++) {
            for (int w = 1; w <= wordLen; w++) {
                int freq = charFreq[w-1][target.charAt(t-1) - 'a'];
                dp[t][w] = (dp[t][w-1] + (freq * dp[t-1][w-1]) % MOD) % MOD;
            }
        }

        return (int) dp[targetLen][wordLen];
    }
}
