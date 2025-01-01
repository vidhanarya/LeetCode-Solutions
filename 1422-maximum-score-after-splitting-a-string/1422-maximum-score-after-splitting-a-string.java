class Solution {
    public int maxScore(String s) {
        int rightOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') rightOnes++;
        }

        int result = 0, leftZeros = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') leftZeros++;
            else rightOnes--;

            result = Math.max(result, leftZeros + rightOnes);
        }

        return result;
    }
}