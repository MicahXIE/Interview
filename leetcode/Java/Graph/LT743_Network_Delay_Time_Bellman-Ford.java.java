class Solution {  //Bellman-Ford 43ms 16.72% time O(NE) space O(N)
    public int networkDelayTime(int[][] times, int N, int K) {
        double[] disTo = new double[N];
        
        Arrays.fill(disTo, Double.POSITIVE_INFINITY);
        disTo[K - 1] = 0;
        for (int i = 1; i < N; i++) {
            for (int[] edge : times) {
                int u = edge[0] - 1, v = edge[1] - 1, w = edge[2];
                disTo[v] = Math.min(disTo[v], disTo[u] + w);
            }
        }
        
        double res = Double.MIN_VALUE;
        for (int i = 0; i < N; ++i) {
            res = Math.max(res, disTo[i]);
        }
        
        return res == Double.POSITIVE_INFINITY ? -1 : (int) res;
    }
}