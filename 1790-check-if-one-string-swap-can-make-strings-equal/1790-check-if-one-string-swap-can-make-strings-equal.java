class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> mismatchIdx = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) continue;

            mismatchIdx.add(i);
            if (mismatchIdx.size() > 2) return false;
        }
        
        if (mismatchIdx.size() != 2) return (mismatchIdx.size() == 0);

        int idx1 = mismatchIdx.get(0), idx2 = mismatchIdx.get(1);
        return (s1.charAt(idx1) == s2.charAt(idx2) && s1.charAt(idx2) == s2.charAt(idx1));
    }
}