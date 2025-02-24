class Solution {
    int maxProfit;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = edges.length + 1;
        maxProfit = Integer.MIN_VALUE;

        List<Integer>[] tree = new ArrayList[n];
        for (int[] edge : edges) {
            if (tree[edge[0]] == null) tree[edge[0]] = new ArrayList<>();
            if (tree[edge[1]] == null) tree[edge[1]] = new ArrayList<>();

            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        int[] bobVisited = new int[n];
        Arrays.fill(bobVisited, -1);
        moveBob(tree, bobVisited, 0, bob);

        int[] aliceVisited = new int[n];
        Arrays.fill(aliceVisited, -1);
        moveAlice(tree, aliceVisited, bobVisited, amount, 0, 0, 0);

        return maxProfit;
    }

    private void moveAlice(List<Integer>[] tree, int[] aliceVisited, int[] bobVisited, int[] amount, int root, int depth, int currSum) {
        if (aliceVisited[root] != - 1) return;

        aliceVisited[root] = 1;
        if (bobVisited[root] == depth) currSum += amount[root] / 2;
        else if (bobVisited[root] > depth) currSum += amount[root];

        for (int child : tree[root]) {
            moveAlice(tree, aliceVisited, bobVisited, amount, child, depth+1, currSum);
        }

        if (root != 0 && tree[root].size() == 1) {
            this.maxProfit = Math.max(this.maxProfit, currSum);
        }
        return;
    }

    private int moveBob(List<Integer>[] tree, int[] visited, int root, int target) {
        if (visited[root] != -1) return visited[root];
        
        visited[root] = tree.length;
        for (int child : tree[root]) {
            visited[root] = Math.min(visited[root], moveBob(tree, visited, child, target) + 1);
        }

        if (root == target) {
            visited[root] = 0;
        }
        return visited[root];
    }
}