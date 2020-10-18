// use two dimension array to replace hash map
// Arrays sort by age then score
// similar to LT300 Longest Increasing Subsequence
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {  // 49ms 33% time O(n^2) space O(2n + n + 1)
        int n = scores.length;
        int[][] pairs = new int[n][2];
        
        for (int i = 0; i < n; ++i) {
            pairs[i][0] = scores[i];
            pairs[i][1] = ages[i];
        }
        
        Arrays.sort(pairs, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]); // sort by age then score
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = pairs[i - 1][0];
            for (int j = i - 1; j >= 1; --j) {
                if (pairs[j - 1][1] == pairs[i - 1][1] || pairs[j - 1][0] <= pairs[i - 1][0]) {
                    dp[i] = Math.max(dp[i], pairs[i - 1][0] + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        
        return max;
        
    }
}