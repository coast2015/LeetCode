/*
Best Time to Buy and Sell Stock IV 

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.

Show Tags


*/

public class Solution {
    
    public int maxProfit(int k, int[] prices) {
        return max(prices, k);
    }
    
    public int max(int[] prices, int k) {       // k: k times transactions
        int len = prices.length;        
        if(len == 0) {
            return 0;
        }
        if(k>=prices.length){
            return this.buyAsMany(prices);
        }
        
        int[][] local = new int[len][k+1];      // local[i][j]: max profit till i day, j transactions,
                                                // where there is transaction happening on i day
        int[][] global = new int[len][k+1];     // global[i][j]: max profit across i days, j transactions
        for(int j=1; j<=k; j++) {
           
             for(int i=1; i<len; i++){
                  int diff = prices[i] - prices[i-1];
                  
                local[i][j] = Math.max(global[i-1][j-1]+Math.max(diff,0), local[i-1][j]+diff);
                global[i][j] = Math.max(global[i-1][j], local[i][j]);
            }
        }
        return global[len-1][k];
    }
    
    
    public int buyAsMany(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        
        int sum = 0;
        
        for(int i= 1; i<prices.length; i++){
            int delta = prices[i] -prices[i-1];
            if(delta>0){
                sum+= delta;
            }
        }
        
        return sum;
        
    }
}
