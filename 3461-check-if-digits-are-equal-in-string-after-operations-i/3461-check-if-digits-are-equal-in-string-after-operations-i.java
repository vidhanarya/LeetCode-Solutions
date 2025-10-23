class Solution {
    public boolean hasSameDigits(String s) {
        List<Integer> nums = new ArrayList<>();
        for (char c : s.toCharArray()) {
            nums.add(c-'0');
        }

        while (nums.size() > 2) {
            List<Integer> newNums = new ArrayList<>();
            for (int i = 0; i < nums.size() - 1; i++) {
                newNums.add((nums.get(i) + nums.get(i+1)) % 10);
            }
            nums = newNums;
        }

        return nums.get(0) == nums.get(1);
    }
}