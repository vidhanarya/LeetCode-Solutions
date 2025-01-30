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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            checkPath(root, result, new ArrayList<>(), targetSum);
        }
        return result;
    }

    public void checkPath(TreeNode root, List<List<Integer>> result, List<Integer> currPath, int target) {
        currPath.add(root.val);
        int newTarget = target - root.val;
        if (root.left != null) {
            checkPath(root.left, result, currPath, newTarget);
        }
        if (root.right != null) {
            checkPath(root.right, result, currPath, newTarget);
        }
        if (root.left == null && root.right == null && newTarget == 0) {
            result.add(new ArrayList<>(currPath));
        }
        currPath.removeLast();
    }
}