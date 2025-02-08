class Solution {
    int[] root;
    int[] rank;

    public boolean validTree(int n, int[][] edges) {
        root = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if (isConnected(a, b)) return false;

            connect(a, b);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (find(i) == i) count++;
        }

        return (count == 1);
    }

    private boolean isConnected(int a, int b) {
        return (find(a) == find(b));
    }

    private int find(int a) {
        if (root[a] == a) return a;
        return (root[a] = find(root[a]));
    }

    private void connect(int a, int b) {
        int rootA = find(a), rootB = find(b);
        int rankA = rank[a], rankB = rank[b];

        if (rankA > rankB) root[rootB] = rootA;
        else if (rankB > rankA) root[rootA] = rootB;
        else {
            root[rootB] = rootA;
            rank[a]++;
        }
    }
}