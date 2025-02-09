class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums.length == 0) return ranges;

        int start = 0;
        for (int end = 1; end < nums.length; end++) {
            if (nums[end] != nums[end-1]+1) {
                ranges.add(getRange(nums[start], nums[end-1]));
                start = end;
            }
        }
        ranges.add(getRange(nums[start], nums[nums.length-1]));
        return ranges;
    }

    public String getRange(int i, int j) {
        if (i == j) return String.valueOf(i);
        return i + "->" + j;
    }
}