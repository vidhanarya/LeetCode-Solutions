class Solution {
    public long maximumBooks(int[] books) {
        long[] prefix = new long[books.length];
        Stack<Integer> stack = new Stack<>();
        prefix[0] = books[0];
        long maxBooks = books[0];
        
        stack.addLast(0);
        for (int i = 1; i < books.length; i++) {
            while (!stack.empty() && books[i] - (i - stack.peek())  < books[stack.peek()]) {
                stack.pop();
            }

            int n = Math.min(books[i], i+1);
            if (!stack.empty()) {
                prefix[i] = prefix[stack.peek()];
                n = Math.min(books[i], i - stack.peek());
            }
            prefix[i] += ((long) n * (long) (2 * books[i] + 1 - n)) / 2;
            maxBooks = Math.max(maxBooks, prefix[i]);
            stack.push(i);
        }

        return maxBooks;
    }
}
