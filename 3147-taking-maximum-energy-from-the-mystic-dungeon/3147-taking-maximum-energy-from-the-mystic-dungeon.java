class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int maxEnergy = Integer.MIN_VALUE;
        for (int j = energy.length-1; j >= 0; j--) {
            if (j+k < energy.length) {
                energy[j] += energy[j+k];
            }

            maxEnergy = Math.max(maxEnergy, energy[j]);
        }
        return maxEnergy;
    }
}