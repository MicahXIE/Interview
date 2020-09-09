class Solution {  // 6ms 96.46% *
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        List<List<String>> res = new ArrayList<>();
        
        if (strs == null) return res;
        for (int i = 0; i < strs.length; ++i) {
            String original = strs[i];
            char[] ch = original.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);
            if (map.isEmpty() || map.get(sorted) == null) {
                List<String> str = new ArrayList<String>();
                str.add(strs[i]);
                map.put(sorted, str);
            } else {
                map.get(sorted).add(strs[i]);
            }
        }
        
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
        
    }
}