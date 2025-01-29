class UnionFind {
    Map<Integer, Integer> root;
    Map<Integer, Integer> rank;

    UnionFind() {
        root = new HashMap<>();
        rank = new HashMap<>();
    }

    public int find(int n) {
        if (root.getOrDefault(n, n) == n) return n;
        int r = find(root.get(n));
        root.put(n, r);
        return r;
    }

    public void union(int a, int b) {
        int rootA = find(a), rootB = find(b);
        int rankA = rank.getOrDefault(rootA, 1), rankB = rank.getOrDefault(rootB, 1);

        if (rankA < rankB) root.put(rootA, rootB);
        else if (rankA > rankB) root.put(rootB, rootA);
        else {
            root.put(rootB, rootA);
            rank.put(rootA, rankA+1);
        }
    }

    public boolean isConnected(int a, int b) {
        return (find(a) == find(b));
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind();
        for (int[] edge : edges) {
            int a = uf.find(edge[0]);
            int b = uf.find(edge[1]);

            if (uf.isConnected(a, b)) {
                return edge;
            }
            uf.union(a, b);
        }

        return new int[2];
    }
}