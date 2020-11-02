class Solution {  //djikstra: prority queue + BFS 19ms 55.23% time O(E log V)
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();        
        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        
        boolean[] visited = new boolean[N + 1];
        int res = 0;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        pq.add(new int[]{0, K});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[1];
            int curDist = cur[0];
            
            if (visited[curNode]) continue;
            visited[curNode] = true;
            res = curDist;
            N--;
            if (N == 0) return res;
            if (map.containsKey(curNode)) {
                for (int next : map.get(curNode).keySet()) {
                    pq.offer(new int[]{curDist + map.get(curNode).get(next), next});
                }
            }
        }
        
        return -1;
    }
}