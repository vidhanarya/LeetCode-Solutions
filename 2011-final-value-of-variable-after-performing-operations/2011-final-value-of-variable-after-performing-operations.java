class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for (String op : operations) {
            if (op.charAt(0) == '+' || op.charAt(2) == '+') result++;
            else result--;
        }

        return result;
    }
}