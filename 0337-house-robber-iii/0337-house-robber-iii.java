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
    Map<Integer, Integer[]> memo;

    public int rob(TreeNode root) {
        memo = new HashMap<>();
        return dp(root, 0, 0);
    }

    public int dp(TreeNode root, int id, int skip) {
        if (memo.containsKey(id) && memo.get(id)[skip] != -1) return memo.get(id)[skip];
        if (root == null) return 0;

        int ans = dp(root.left, 2*id + 1, 0) + dp(root.right, 2*id + 2, 0);
        if (skip == 0) {
            ans = Math.max(ans, root.val + dp(root.left, 2*id + 1, 1) + dp(root.right, 2*id + 2, 1));
        }

        Integer[] result = memo.getOrDefault(id, new Integer[]{-1, -1});
        result[skip] = ans;
        memo.put(id, result);
        return ans;
    }
}