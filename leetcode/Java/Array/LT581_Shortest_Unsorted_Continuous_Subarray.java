class Solution { // 1ms 100% time O(n) space O(1)
 public int findUnsortedSubarray(int[] nums) {
        if(nums == null){
            return 0;
        }

        int start = -1, end = -1;
        int max = nums[0];
        int min = Integer.MAX_VALUE;
        for(int i =1; i<nums.length; i++){
            if(nums[i] < nums[i-1] || max > nums[i]){
                end = i;

                max = Math.max(max, nums[i-1]);
                min = Math.min(min, nums[i]);
                if(start == -1){
                    start = i-1;
                }
            }
        }
        
        if(start == -1){
            return 0;
        }
        for(int i=0; i<=start; i++){ //first number greater than min
            if(nums[i] > min){
                start = i;
                break;
            }
        }
        
        for(int i =nums.length -1; i>=end;i--){//first number less than max
            if(nums[i] < max){
                end = i;
                break;
            }
        }
        
        return start != -1 ? end - start + 1 : 0;
    }
}