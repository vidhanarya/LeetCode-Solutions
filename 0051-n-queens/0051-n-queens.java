class Solution {
    Set<Integer> col;
    Set<Integer> dia;
    Set<Integer> antiDia;
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        col = new HashSet<>();
        dia = new HashSet<>();
        antiDia = new HashSet<>();
        result = new ArrayList<>();

        backtrack(new ArrayList<>(), n, 0);
        return result;
    }

    private void backtrack(List<String> curr, int n, int i) {
        if (i == n) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (canBeSeen(i, j)) continue;

            placeQueen(curr, n, i, j);
            backtrack(curr, n, i+1);
            removeQueen(curr, i, j);
        }
    }

    private void placeQueen(List<String> curr, int n, int i, int j) {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < n; x++) {
            if (x == j) sb.append('Q');
            else sb.append('.');
        }

        curr.add(sb.toString());
        col.add(j);
        dia.add(j+i);
        antiDia.add(j-i);
    }

    private void removeQueen(List<String> curr, int i, int j) {
        curr.remove(curr.size() - 1);
        col.remove(j);
        dia.remove(j+i);
        antiDia.remove(j-i);
    }

    private boolean canBeSeen(int i, int j) {
        return (col.contains(j) || dia.contains(j+i) || antiDia.contains(j-i));
    }
}