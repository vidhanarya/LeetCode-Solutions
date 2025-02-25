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
    public int diameterOfBinaryTree(TreeNode root) {
        return getDiameter(root)[1];
    }

    public int[] getDiameter(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = getDiameter(root.left);
        int[] right = getDiameter(root.right);

        int maxDepth = Math.max(left[0], right[0]) + 1;
        int currDia = left[0] + right[0];
        int maxDia = Math.max(currDia, Math.max(left[1], right[1]));

        return new int[]{maxDepth, maxDia};
    }
}