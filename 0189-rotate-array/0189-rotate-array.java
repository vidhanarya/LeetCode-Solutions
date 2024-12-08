class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) return;
        
        Set<Integer> rotated = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (rotated.contains(i)) continue;
            
            int j = (i+k) % n;
            while (i != j) {
                rotated.add(j);

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j = (j+k) % n;
            }
            rotated.add(i);
        }
    }
}

// [1,2,3,4,5,6,7,8]
// [7,2,1,4,3,6,5,8]