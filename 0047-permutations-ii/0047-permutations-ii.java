class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        boolean[] used = new boolean[8];
        backtrack(resultSet, new ArrayList<>(), used, nums);

        List<List<Integer>> resultList = new ArrayList<>();
        for (List<Integer> perm: resultSet) {
            resultList.add(perm);
        }
        return resultList;
    }

    public void backtrack(Set<List<Integer>> result, List<Integer> curr, boolean[] used, int[] nums) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            curr.add(nums[i]);
            backtrack(result, curr, used, nums);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}