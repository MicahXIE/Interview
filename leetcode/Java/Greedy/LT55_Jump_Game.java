/*
class Solution { // 226ms 32.30%
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return true;
        
        int[] visited = new int[nums.length];
        visited[0] = 1;
        for (int i = 0; (i < nums.length - 1) && visited[i] == 1; ++i) {
            if (nums[i] + i >= nums.length - 1) 
                return true;
            for (int j = nums[i]; j > 0; --j) {
                visited[i + j] = 1;
            }
        }
        return false;
    }
}
*/
// official greedy  1ms 99.43% time O(n) space O(1)
public class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}