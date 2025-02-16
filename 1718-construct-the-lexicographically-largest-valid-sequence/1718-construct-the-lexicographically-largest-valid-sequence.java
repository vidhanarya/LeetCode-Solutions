class Solution {
    public int[] constructDistancedSequence(int n) {
        return backtrack(new int[2*n-1], n, 0, new HashSet<>());
    }

    public int[] backtrack(int[] curr, int n, int i, Set<Integer> visited) {
        if (i >= curr.length) return curr;
        if (curr[i] != 0) return backtrack(curr, n, i+1, visited);

        for (int k = n; k >= 1; k--) {
            if (visited.contains(k)) continue;
            if (k != 1 && (i + k >= curr.length || curr[i+k] != 0)) continue;

            curr[i] = k;
            if (k != 1) curr[i+k] = k;
            visited.add(k);

            int[] result = backtrack(curr, n, i+1, visited);
            if (result.length > 0) return result;

            visited.remove(k);
            if (k != 1) curr[i+k] = 0;
            curr[i] = 0;
        }

        return new int[0];
    }
}