// dfs with memo
// l refers to the range of sumsum and nn refers to the size of numsnums array.
// time O(l * n) space O(l * n)
class Solution {
    
    public int findTargetSumWays(int[] nums, int S) {   // 110ms 48.54% time O(l*n) space O(l*n) 
        return helper(nums, 0, 0, S, new HashMap<>());
    }
    
    private int helper(int[] nums, int index, int sum, int target, HashMap<String, Integer> map) {
        String encoding = index + "->" + sum;
        if (map.containsKey(encoding)) {
            return map.get(encoding);
        }
        
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }
        
        int curSum = nums[index];
        int add = helper(nums, index + 1, sum + curSum, target, map);
        int substract = helper(nums, index + 1, sum - curSum, target, map);
        map.put(encoding, add + substract);
        return add + substract;
    }

}