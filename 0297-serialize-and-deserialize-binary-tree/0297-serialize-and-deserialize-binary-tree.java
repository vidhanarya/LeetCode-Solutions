/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private final String nullVal = "n";
    private final String delimiter = "|";
    private final String delimiterRegex = "\\|";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "()";
        
        String rootVal = String.valueOf(root.val);
        String leftVal = serialize(root.left);
        String rightVal = serialize(root.right);

        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(rootVal);
        sb.append(leftVal);
        sb.append(rightVal);
        sb.append(")");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {        
        Map<Integer, Integer> treeMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == '(') stack.push(i);
            else if (data.charAt(i) == ')') treeMap.put(stack.pop(), i);
        }

        return getRoot(data, treeMap, 0, data.length()-1);
    }

    private TreeNode getRoot(String data, Map<Integer, Integer> treeMap, int start, int end) {
        if (end - start == 1) return null;

        int numEndIndex = data.indexOf('(', start+1);
        int leftStart = numEndIndex, leftEnd = treeMap.get(numEndIndex);
        int rightStart = leftEnd+1, rightEnd = treeMap.get(leftEnd+1);

        int rootVal = Integer.parseInt(data.substring(start+1, numEndIndex));
        TreeNode root = new TreeNode(rootVal);
        root.left = getRoot(data, treeMap, leftStart, leftEnd);
        root.right = getRoot(data, treeMap, rightStart, rightEnd);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));