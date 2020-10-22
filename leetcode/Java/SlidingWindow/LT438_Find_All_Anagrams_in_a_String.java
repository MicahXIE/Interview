class Solution {  // 18ms 42.51% sliding window for string time O(n) space worst O(m)
    public List<Integer> findAnagrams(String s, String p) {
        int len = s.length();
        int n = p.length();
        List<Integer> res = new LinkedList<>();
        
        if (len < n) return res;
        
        // store p character and frequency
        HashMap<Character, Integer> reference = new HashMap<>();
        for (char c : p.toCharArray()) {
            reference.put(c, reference.getOrDefault(c, 0) + 1);
        }
        // store matching character and frequency
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, match = 0;
        while (end < len) {
            char t = s.charAt(end);
            if (reference.containsKey(t)) {
                map.put(t, map.getOrDefault(t, 0) + 1);
                if (map.get(t).equals(reference.get(t))) {
                    match++;
                }
            } 
            
            // move start point
            while (match == reference.size()) {
                if ((end - start + 1) == p.length()) {
                    res.add(start);   
                }
                
                char ch = s.charAt(start);
                if (map.containsKey(s.charAt(start))) {
                    map.put(ch, map.get(ch) - 1);
                    if (map.get(ch) < reference.get(ch)) match--;
                }
                start++;
            }
            end++;
        }
        return res;
    }
    
}