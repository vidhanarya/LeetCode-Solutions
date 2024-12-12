class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long total = 0;
        for (int gift : gifts) {
            pq.add(gift);
            total += gift;
        }

        while (k > 0) {
            int n = pq.remove();
            int sqrt = (int) Math.sqrt(n);
            total -= n - sqrt;
            pq.add(sqrt);
            k--;
        }

        return total;
    }
}