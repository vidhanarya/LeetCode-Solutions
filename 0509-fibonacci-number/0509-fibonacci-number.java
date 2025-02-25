class Solution {
    public int fib(int n) {
        if (n <= 1) return n;

        int first = 0, second = 1;        
        while (n-- > 1) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }
}