/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;

        Queue<Node> currLevel = new LinkedList<>();
        currLevel.offer(root);

        while (!currLevel.isEmpty()) {
            int size = currLevel.size();
            Node prev = null;
            
            for (int i = 0; i < size; i++) {
                Node curr = currLevel.poll();
                if (prev != null) {
                    prev.next = curr;
                }

                if (curr.left != null) currLevel.offer(curr.left);
                if (curr.right != null) currLevel.offer(curr.right);

                prev = curr;
            }
        }

        return root;
    }
}