class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //回溯法
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<Integer>(); 
        backtrack(result, tmp, nums, 0);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> tmp, int[] nums, int start){
        result.add(new ArrayList(tmp));
        for (int i = start; i < nums.length; i++){
            tmp.add(nums[i]);
            backtrack(result, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}