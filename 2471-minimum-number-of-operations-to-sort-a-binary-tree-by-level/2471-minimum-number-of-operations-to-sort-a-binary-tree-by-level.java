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
    public int minimumOperations(TreeNode root) {
        int result = 0;
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);
        while (!bfs.isEmpty()) {
            int levelSize = bfs.size();
            int[] level = new int[levelSize];

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = bfs.poll();
                level[i] = node.val;

                if (node.left != null) bfs.offer(node.left);
                if (node.right != null) bfs.offer(node.right);
            }

            result += getMinimumSwaps(level);
        }

        return result;
    }

    public int getMinimumSwaps(int[] level) {
        int[] sortedLevel = level.clone();
        Arrays.sort(sortedLevel);

        Map<Integer, Integer> sortedIndex = new HashMap<>();
        for (int i = 0; i < level.length; i++) {
            sortedIndex.put(level[i], i);
        }

        int numSwaps = 0;
        for (int i = 0; i < level.length; i++) {
            if (level[i] == sortedLevel[i]) continue;

            numSwaps++;
            int newPos = sortedIndex.get(sortedLevel[i]);
            sortedIndex.put(level[i], newPos);
            sortedIndex.put(sortedLevel[i], i);
            swap(level, i, newPos);
        }

        return numSwaps;
    }

    public void swap(int[] level, int i, int j) {
        int temp = level[i];
        level[i] = level[j];
        level[j] = temp;
    }
}