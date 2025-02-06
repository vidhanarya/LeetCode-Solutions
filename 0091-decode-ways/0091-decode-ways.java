class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);

        if (!isValid(s)) return 0;
        return dp(s, memo, 0);
    }

    public int dp(String s, int[] memo, int idx) {
        if (idx >= s.length()) return 1;
        if (s.charAt(idx) == '0') return 0;
        if (memo[idx] != -1) return memo[idx];

        int decodings = 0;
        decodings += dp(s, memo, idx+1);
        
        if (idx < s.length()-1 && Integer.parseInt(s.substring(idx, idx+2)) <= 26) {
            decodings += dp(s, memo, idx+2);
        }

        memo[idx] = decodings;
        return decodings;
    }

    public boolean isValid(String s) {
        if (s.charAt(0) == '0') return false;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0' && !(s.charAt(i-1) == '1' || s.charAt(i-1) == '2')) {
                return false;
            }
        }

        return true;
    }
}