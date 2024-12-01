class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            backtrack(result, i, n - 1, k);
        }
        
        int[] finalResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i);
        }
        
        return finalResult;
    }
    
    public void backtrack(List<Integer> result, int currNum, int n, int k) {
        if (n == 0) {
            result.add(currNum);
            return;
        }
        
        if (currNum % 10 + k >= 0 && currNum % 10 + k <= 9) {
            int lastDigit = currNum % 10 + k;
            currNum = currNum * 10 + lastDigit;
            backtrack(result, currNum, n - 1, k);
            currNum = (currNum - lastDigit) / 10;
        }
        
        if (k != 0 && currNum % 10 - k >= 0 && currNum % 10 - k <= 9) {
            int lastDigit = currNum % 10 - k;
            currNum = currNum * 10 + lastDigit;
            backtrack(result, currNum, n - 1, k);
            currNum = (currNum - lastDigit) / 10;
        }
    }
}