class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, minPrice = Integer.MAX_VALUE;
        for (int price: prices) {
            minPrice = Math.min(minPrice, price);
            profit = Math.max(profit, price - minPrice);
        }

        return profit;
    }
}