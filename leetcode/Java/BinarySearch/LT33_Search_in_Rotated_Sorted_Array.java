/*
0　　1　　2　　 4　　5　　6　　7
7　　0　　1　　 2　　4　　5　　6
6　　7　　0　　 1　　2　　4　　5
5　　6　　7　　 0　　1　　2　　4
4　　5　　6　　 7　　0　　1　　2
2　　4　　5　　 6　　7　　0　　1
1　　2　　4　　 5　　6　　7　　0
*/

class Solution { // 0ms 100%
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && nums[right] >= target) left = mid + 1;
                else right = mid - 1;
            } else {
                if (nums[mid] > target && nums[left] <= target) right = mid - 1;
                else left = mid + 1;     
            }
        }
        
        return -1;
    }
}