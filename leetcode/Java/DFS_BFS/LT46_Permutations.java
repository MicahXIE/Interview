class Solution {  // 2ms 62.87%
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        
        List<Integer> out = new ArrayList<Integer>();
        List<Integer> visited = new ArrayList<Integer>(Collections.nCopies(nums.length, 0));
        permuteDFS(nums, 0, visited, out, res);
        return res;
    }
    private void permuteDFS(int[] nums, int level, List<Integer> visited, List<Integer> out, List<List<Integer>> res) {
        if (level == nums.length) res.add(new ArrayList<Integer>(out));
        
        for (int i = 0; i < nums.length; ++i) {
            if (visited.get(i) == 1) continue;
            visited.set(i, 1);
            out.add(nums[i]);
            permuteDFS(nums, level + 1, visited, out, res);
            out.remove(out.size() - 1);
            visited.set(i, 0);
        }
    }
}