class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        List<Integer> sortedIndex = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            sortedIndex.add(i);
        }

        sortedIndex.sort(Comparator.comparingInt(a -> nums[a]));

        List<Integer> indexes = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        indexes.add(sortedIndex.getFirst());
        values.add(nums[sortedIndex.getFirst()]);

        for (int i = 1; i < sortedIndex.size(); i++) {
            if (Math.abs(nums[sortedIndex.get(i)] - nums[sortedIndex.get(i-1)]) > limit) {
                update(nums, indexes, values);
            }

            indexes.add(sortedIndex.get(i));
            values.add(nums[sortedIndex.get(i)]);
        }

        update(nums, indexes, values);
        return nums;
    }

    public void update(int[] nums, List<Integer> indexes, List<Integer> values) {
        indexes.sort(Comparator.comparingInt(a -> a));
        for (int j = 0; j < indexes.size(); j++) {
            nums[indexes.get(j)] = values.get(j);
        }

        indexes.clear();
        values.clear();
    }
}
