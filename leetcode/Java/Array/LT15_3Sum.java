class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null)
            return null;
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        if (len < 3)
            return res;
        for (int i=0; i<len-2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int lo = i+1, hi = len-1, sum = 0-nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++; hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }   
            }
        }
        return res;
    }
}