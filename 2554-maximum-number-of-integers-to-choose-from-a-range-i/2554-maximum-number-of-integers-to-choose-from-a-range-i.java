class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> banSet = new HashSet<>();
        for (int bannedNum : banned) banSet.add(bannedNum);

        int count = 0, currSum = 0;
        for (int i = 1; i <= n; i++) {
            if (currSum + i > maxSum) break;
            if (banSet.contains(i)) continue;

            count++;
            currSum += i;
        }

        return count;
    }
}