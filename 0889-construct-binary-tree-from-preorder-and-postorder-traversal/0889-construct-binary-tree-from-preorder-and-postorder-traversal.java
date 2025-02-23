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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int preIdx = 0, postIdx = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[preIdx++]);
        stack.push(root);

        while (!stack.empty() && preIdx < preorder.length && postIdx < postorder.length) {
            if (postorder[postIdx] == stack.peek().val) {
                stack.pop();
                postIdx++;
                continue;
            }

            TreeNode node = new TreeNode(preorder[preIdx]);
            TreeNode parent = stack.peek();

            if (parent.left == null) parent.left = node;
            else parent.right = node;
            stack.push(node);
            preIdx++;
        }

        return root;
    }
}