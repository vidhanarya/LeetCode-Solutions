class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            char c = (nums[i].charAt(i) == '0') ? '1' : '0';
            result.append(c);
        }

        return result.toString();
    }
}