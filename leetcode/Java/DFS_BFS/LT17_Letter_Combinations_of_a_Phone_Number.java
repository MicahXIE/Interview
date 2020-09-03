//reference: https://zxi.mytechroad.com/blog/searching/leetcode-17-letter-combinations-of-a-phone-number/

class Solution { // dfs
    public List<String> letterCombinations(String digits) {
        String[] d = new String[] {" ",
                                   "",
                                   "abc",
                                   "def",
                                   "ghi",
                                   "jkl",
                                   "mno",
                                   "pqrs",
                                   "tuv",
                                   "wxyz",
                                  };
        List<String> ans = new ArrayList<>();
        char[] cur = new char[digits.length()];
        dfs(digits, d, 0, cur, ans);
        return ans;
    }
    
    private void dfs(String digits, String[] d, int l, char[] cur, List<String> ans) {
        if (l == digits.length()) {
            if (l > 0) ans.add(new String(cur));
            return;
        }
        
        String s = d[Character.getNumericValue(digits.charAt(l))];
        for (int i = 0; i < s.length(); ++i) {
            cur[l] = s.charAt(i);
            dfs(digits, d, l + 1, cur, ans);
        }
    }
}