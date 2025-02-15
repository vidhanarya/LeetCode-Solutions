class Solution {
    public int punishmentNumber(int n) {
        int punishment = 0;
        for (int i = 1; i <= n; i++) {
            if (canPunish(String.valueOf(i * i), 0, i)) {
                punishment += i * i;
            }
        }

        return punishment;
    }

    public boolean canPunish(String num, int start, int target) {
        if (start == num.length() && target == 0) return true;
        if (start >= num.length()) return false;

        for (int end = start+1; end <= num.length(); end++) {
            int currSum = Integer.parseInt(num.substring(start, end));
            if (currSum > target) break;

            if (canPunish(num, end, target - currSum)) {
                return true;
            }
        }

        return false;
    }
}