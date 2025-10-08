class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int[] result = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            result[i] = search(potions, success, spells[i]);
        }

        return result;
    }

    public int search(int[] potions, long sucess, long spell) {
        int left = 0, right = potions.length;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if ((long) potions[mid] * spell >= sucess) right = mid;
            else left = mid+1;
        }

        return potions.length - left;
    }
}