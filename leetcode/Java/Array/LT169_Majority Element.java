class Solution {  // Boyer-Moore Voting Algorithm O(n) 2ms 72.21%
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}

/*
class Solution {  // O(nlogn) 1ms 99.92%
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
*/