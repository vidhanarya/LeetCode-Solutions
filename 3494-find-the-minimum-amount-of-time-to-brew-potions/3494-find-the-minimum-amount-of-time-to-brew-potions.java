class Solution {
    public long minTime(int[] skill, int[] mana) {
        long[] curr = new long[skill.length];

        for (int m = 0; m < mana.length; m++) {
            curr[0] = curr[0] + skill[0]*mana[m];
            for (int s = 1; s < skill.length; s++) {
                curr[s] = Math.max(curr[s-1], curr[s]) + skill[s]*mana[m];
            }

            for (int s = skill.length - 2; s >= 0; s--) {
                curr[s] = Math.max(curr[s], curr[s+1] - skill[s+1]*mana[m]);
            }
        }

        return curr[skill.length-1];
    }
}