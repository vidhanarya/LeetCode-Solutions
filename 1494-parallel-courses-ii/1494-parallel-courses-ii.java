class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        if (k == 1) return n;

        int[] prerequisite = new int[n];
        for (int[] relation : relations) {
            prerequisite[relation[1]-1] |= (1 << (relation[0] - 1));
        }

        int[] dp = new int[1 << n];
        Arrays.fill(dp, n);
        dp[0] = 0;

        for (int mask = 0; mask < dp.length; mask++) {
            int canTake = 0;
            
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) continue;
                if ((mask & prerequisite[i]) != prerequisite[i]) continue;
                
                canTake |= (1 << i);
            }

            for (int take = canTake; take > 0; take = (take - 1) & canTake) {
                if (Integer.bitCount(take) > k) continue;

                dp[take | mask] = Math.min(dp[take | mask], dp[mask] + 1);
            }
        }

        return dp[dp.length-1];
    }
}
