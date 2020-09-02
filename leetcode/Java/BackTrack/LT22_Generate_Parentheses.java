class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, n, "", res);
        return res;
    }
    private void backtrack(int left, int right, String out, List<String> res) {
        if (left < 0 || right < 0 || left > right) return;  // left > right to avoid )(
        if (left == 0 && right == 0) res.add(new String(out));
        
        backtrack(left-1, right, out+"(", res);
        backtrack(left, right-1, out+")", res);
    }
}