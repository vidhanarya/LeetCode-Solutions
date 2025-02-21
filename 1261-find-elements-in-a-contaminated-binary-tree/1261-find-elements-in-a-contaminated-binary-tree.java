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
class FindElements {
    Set<Integer> values;

    public FindElements(TreeNode root) {
        values = new HashSet<>();

        Queue<Pair<TreeNode, Integer>> bfs = new LinkedList<>();
        bfs.offer(new Pair<>(root, 0));

        while (!bfs.isEmpty()) {
            Pair<TreeNode, Integer> pair = bfs.poll();
            TreeNode node = pair.getKey();
            int value = pair.getValue();
            values.add(value);

            if (node.left != null) bfs.offer(new Pair<>(node.left, 2*value+1));
            if (node.right != null) bfs.offer(new Pair<>(node.right, 2*value+2));
        }
    }
    
    public boolean find(int target) {
        return values.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */