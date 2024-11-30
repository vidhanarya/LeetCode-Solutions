class Solution {
    int ans;
    Set<Integer> coloumn;
    Set<Integer> diagonal;
    Set<Integer> antiDiagonal;

    public int totalNQueens(int n) {
        ans = 0;
        coloumn = new HashSet<>();
        diagonal = new HashSet<>();
        antiDiagonal = new HashSet<>();

        backtrack(n, 0);
        return ans;
    }

    public void backtrack(int n, int r) {
        if (r >= n) {
            ans++;
            return;
        }

        for (int c = 0; c < n; c++) {
            if (coloumn.contains(c) || diagonal.contains(c + r) || antiDiagonal.contains(c - r)) continue;

            coloumn.add(c);
            diagonal.add(c + r);
            antiDiagonal.add(c - r);
            backtrack(n, r + 1);
            coloumn.remove(c);
            diagonal.remove(c + r);
            antiDiagonal.remove(c - r);
        }
    }
}