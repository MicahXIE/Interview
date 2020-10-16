class Solution {  // Topological sort 5ms 68.67%
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < prerequisites.length; ++i) {
            inDegree[prerequisites[i][0]]++;
            if (graph.get(prerequisites[i][1]) != null) 
                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            else {
                List<Integer> lst = new ArrayList<>();
                lst.add(prerequisites[i][0]);
                graph.put(prerequisites[i][1], lst);
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; ++i) {
            if (inDegree[i] == 0)
                queue.add(i);
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            List<Integer> toTake = graph.get(cur);
            for (int i = 0; toTake != null && i < toTake.size(); ++i) {
                inDegree[toTake.get(i)]--;
                if (inDegree[toTake.get(i)] == 0) queue.add(toTake.get(i));
            }
        }
        
        return numCourses == count;
        
    }
}

