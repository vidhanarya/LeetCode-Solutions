class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIdx = 0;
        for (int pushIdx = 0; pushIdx < pushed.length; pushIdx++) {
            stack.push(pushed[pushIdx]);

            while (!stack.empty() && stack.peek() == popped[popIdx]) {
                stack.pop();
                popIdx++;
            }
        }

        return stack.empty();
    }
}