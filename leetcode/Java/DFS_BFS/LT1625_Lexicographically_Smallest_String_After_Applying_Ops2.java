class Solution {  //BFS 118ms 100%
    
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet();
        Queue<String> q = new LinkedList<>();
        String smallest = s;
        
        q.offer(s);
        while (!q.isEmpty()) {
            String cur = q.poll();
            
            if (visited.contains(cur))
                continue;
            if (cur.compareTo(smallest) < 0)
                smallest = cur;
            visited.add(cur);
            
            q.offer(add(cur, a));
            q.offer(rotate(cur, b));
        }
            
        return smallest;
    }
    
    public String rotate(String s, int b) {
        int n = s.length();
        return s.substring(n - b) + s.substring(0, n - b);
        
    }
    
    public String add(String s, int a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (i % 2 == 1) {
                int t = ((c - '0') + a) % 10;
                c = (char)(t + '0');
            }
            sb.append(c);
        }
        return sb.toString();
    }
}