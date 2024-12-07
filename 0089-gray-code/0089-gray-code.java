class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(1);
    
        int curr = 1;
        while (curr < n) {
            int size = result.size() - 1;
            for (int i = size; i >= 0; i--) {
                result.add(result.get(i) ^ (1 << curr));
            }
            curr++;
        }

        return result;
    }
}