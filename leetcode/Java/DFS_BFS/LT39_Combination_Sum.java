// https://goodtecher.com/leetcode-39-combination-sum/ 
// start index 2 3 6 7 是单循环dfs

class Solution { // 3ms 85%
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> out = new ArrayList<Integer>();
        dfs(candidates, target, out, res, 0);
        return res;
    }
    private void dfs(int[] candidates, int target, List<Integer> out, List<List<Integer>> res, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<Integer>(out));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            out.add(candidates[i]);
            dfs(candidates, target-candidates[i], out, res, i);
            out.remove(out.size()-1);
        }
    }
}