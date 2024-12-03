class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) curr.add(1);
                else {
                    int next = result.get(result.size()-1).get(j-1) + result.get(result.size()-1).get(j);
                    curr.add(next);
                }
            }
            result.add(curr);
        }
        return result;
    }
}