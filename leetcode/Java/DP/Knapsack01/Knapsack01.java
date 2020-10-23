// reference : https://www.cnblogs.com/2015110615L/p/6243451.html

public class Knapsack01 {
	public int solution(int[] vals, int[] wt, int w) {
		int[] dp = new int[w + 1]; // wt index at i can get the max value

		int index = 0;
		for (int num : wt) {
			for (int i = w; i > 0; --i) {
				if (i >= num) {
					dp[i] = Math.max(dp[i], dp[i - num] + vals[index]);
				}
			}
			index++;
		}

		return dp[w];

	}

	public static void main(String[] args) {
		int[] vals = {1, 4, 5, 7};
		int[] wt = {1, 3, 4, 5};
		int w = 7;
		Knapsack01 k = new Knapsack01();
		System.out.println(k.solution(vals, wt, w));   // 9
	}
}