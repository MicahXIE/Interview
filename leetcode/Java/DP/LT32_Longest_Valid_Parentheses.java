/*
	 * 对于dp[],i->[0,dp.len)，dp[i]记录[i-dp[i],i]这个区间完成的括号闭合的长度<br>
	 * 而dp[i]的长度取决i-1前一个的闭合长度，还取决于新的闭合区间的前一个dp[i-dp[i]]的闭合长度<br>
*/
class Solution { // 1ms 100%  *
	public int longestValidParentheses(String s) {
		int[] dp = new int[s.length()];
		int max = 0;
		for (int i = 1; i < dp.length; ++i) {
			if (s.charAt(i) == ')') {
				if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
					dp[i] += dp[i - 1] + 2;
				}
				if (i - dp[i] >= 0) {
					dp[i] += dp[i - dp[i]];
				}
				max = Math.max(max, dp[i]);
			}
		}
		return max;
	}
}