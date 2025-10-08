class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int[] result = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            result[i] = potions.length - search(potions, spells[i], success);
        }

        return result;
    }

    private int search(int[] potions, int spell, long success) {
        int l = 0, r = potions.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            
            if ((long) potions[m] * spell >= success) r = m;
            else l = m+1;
        }

        return l;
    }
}