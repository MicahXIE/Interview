class Solution {  //Floyd Warsh 15ms 74.73% time O(n^3) space O(n^2)
    public int networkDelayTime(int[][] times, int N, int K) {
        double[][] disTo = new double[N][N];
        
        for (int i = 0; i < N; i++)
            Arrays.fill(disTo[i], Double.POSITIVE_INFINITY);
        for (int i = 0; i < N; i++) {
            disTo[i][i] = 0;
        }
        for (int[] edge : times) {
            disTo[edge[0] - 1][edge[1] - 1] = edge[2];
        }
        
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (disTo[i][j] > disTo[i][k] + disTo[k][j])
                        disTo[i][j] = disTo[i][k] + disTo[k][j];
                }
            }
        }
        
        double max = Double.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (disTo[K - 1][i] == Double.POSITIVE_INFINITY) return -1;
            max = Math.max(disTo[K - 1][i], max);
        }
        
        return (int)max;
    }
}