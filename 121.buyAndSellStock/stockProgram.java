class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2){return 0;}
        int min = Integer.MAX_VALUE;
        int maxDiff = 0;
       for (int i = 0; i < prices.length; i++){
            if (prices[i] < min){
                min = prices[i];
            }
            int diff = prices[i]-min;
            if (diff > maxDiff){
               maxDiff = diff;
           }
        }
        return maxDiff;

    }
} 
