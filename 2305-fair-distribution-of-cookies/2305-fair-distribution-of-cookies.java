class Solution {
    int result;
    public int distributeCookies(int[] cookies, int k) {
        result = Integer.MAX_VALUE;
        int[] dist = new int[k];
        backtrack(dist, 0, cookies);
        return result;
    }

    public void backtrack(int[] dist, int i, int[] cookies) {
        if (i >= cookies.length) {
            result = Math.min(result, listMax(dist));
            return;
        }

        for (int j = 0; j < dist.length; j++) {
            dist[j] += cookies[i];
            backtrack(dist, i + 1, cookies);
            dist[j] -= cookies[i];
        }
    }

    public int listMax(int[] arr) {
        int max = 0;
        for (int n: arr) max = Math.max(max, n);
        return max;
    }
}