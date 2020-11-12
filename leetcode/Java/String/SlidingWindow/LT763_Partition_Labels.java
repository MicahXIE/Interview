class Solution {  // 3ms 84.38% time O(n) space O(1)
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) return null;
        
        int[] map = new int[26];
        for (int i = 0; i < S.length(); ++i) {
            map[S.charAt(i) - 'a'] = i;
        }
        
        int start = 0, last = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < S.length(); ++i) {
            last = Math.max(last, map[S.charAt(i) - 'a']);
            if (last == i) {
                res.add(last - start + 1);
                start = last + 1;
            }
        }
        
        return res;
        
    }
}