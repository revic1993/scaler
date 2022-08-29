package dsa.leetcode.slidingwindow;
/*
*
* https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/

public class BuySellStocks {
    public static void main(String[] args) {
        BuySellStocks bss = new BuySellStocks();
        System.out.println(bss.maxProfit(new int[]{}));
    }

    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int currentMax = prices[prices.length-1];
        int result = 0;
        for(int i=prices.length-1;i>=0;i--){
            currentMax = Math.max(currentMax,prices[i]);
            result = Math.max(result,currentMax - prices[i]);
        }
        return result;
    }
}
