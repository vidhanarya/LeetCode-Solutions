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
    public TreeNode recoverFromPreorder(String traversal) {
        List<List<TreeNode>> levels = new ArrayList<>();
        int currIdx = 0;

        while (currIdx < traversal.length()) {
            int[] nodeInfo = getNodeInfo(traversal, currIdx);
            int val = nodeInfo[0], depth = nodeInfo[1], nextIdx = nodeInfo[2];
            if (depth == levels.size()) {
                levels.add(new ArrayList<>());
            }

            TreeNode node = new TreeNode(val);
            levels.get(depth).add(node);
            if (depth > 0) {
                TreeNode parent = levels.get(depth-1).getLast();
                if (parent.left == null) parent.left = node;
                else parent.right = node;
            }

            currIdx = nextIdx;
        }

        return levels.get(0).get(0);
    }

    private int[] getNodeInfo(String t, int i) {
        int depth = 0;
        while (i < t.length() && t.charAt(i) == '-') {
            depth++;
            i++;
        }

        StringBuilder num = new StringBuilder();
        while (i < t.length() && t.charAt(i) != '-') {
            num.append(t.charAt(i++));
        }

        int val = Integer.parseInt(num.toString());
        return new int[]{val, depth, i};
    }
}