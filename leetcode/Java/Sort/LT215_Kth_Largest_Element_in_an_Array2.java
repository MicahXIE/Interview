public class Solution {  // 11ms 24.23% quick select
    
    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1, index = k - 1;
        while (start < end) {
            int pivot = partition(nums, start, end);

            if (pivot == index)
                return nums[index];
            else if (pivot < index)
                start = pivot + 1;
            else
                end =  pivot - 1;
        }
        return nums[start];
        
    }
    
    private int partition(int[] nums, int start, int end) {
        int pivotIndex = start;
        while (start <= end) {
            while(start <= end && nums[start] >= nums[pivotIndex]) start++;
            while(start <= end && nums[end] < nums[pivotIndex]) end--;
            if (start > end) break;
            swap(nums, start, end);
        }
        swap(nums, pivotIndex, end);
        return end;
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}