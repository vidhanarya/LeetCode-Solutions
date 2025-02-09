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
    public int findTilt(TreeNode root) {
        return getTilt(root)[0];
    }

    public int[] getTilt(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] left = getTilt(root.left);
        int[] right = getTilt(root.right);

        return new int[]{left[0] + right[0] + Math.abs(left[1] - right[1]), root.val + left[1] + right[1]};
    }
}
