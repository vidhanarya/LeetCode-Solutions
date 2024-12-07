class Solution {
    public int getSum(int a, int b) {
        int carry = b;
        int sum = a;
        while (carry != 0) {
            int temp = sum;
            sum = sum ^ carry;
            carry = (temp & carry) << 1;
            
        }
        return sum;
    }
}