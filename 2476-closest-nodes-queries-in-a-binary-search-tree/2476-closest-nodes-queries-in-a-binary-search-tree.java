/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int q: queries) {
            result.add(search(nums, q));
        }

        return result;
    }

    public List<Integer> search(List<Integer> nums, int q) {
        int l = 0, r = nums.size();

        while (l < r) {
            int m = l + (r - l) / 2;

            if (nums.get(m) == q) return new ArrayList<>(List.of(nums.get(m), nums.get(m)));
            else if (nums.get(m) > q) r = m;
            else l = m + 1;
        }

        int min = (l == 0) ? -1 : nums.get(l - 1);
        int max = (l == nums.size()) ? -1 : nums.get(l);

        return new ArrayList<>(List.of(min, max));
    }

    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;

        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
}