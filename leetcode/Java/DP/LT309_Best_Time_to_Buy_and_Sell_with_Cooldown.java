class Solution {   // time O(n) space O(1)
    public int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE;
        int sold = 0;
        int rest = 0;
        
        for (int price : prices) { // hold sold rest in sequence
            int prev = sold;
            hold = Math.max(hold, rest - price);
            sold = hold + price;
            rest = Math.max(rest, prev);
        }
        
        return Math.max(sold, rest);
        
    }
}