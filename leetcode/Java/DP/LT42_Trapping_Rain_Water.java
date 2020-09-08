public class Solution { // 1ms 94.68% time O(n) space O(n)
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        
        int res = 0, mx = 0, len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        
        for (int i = 0; i < len; i++) 
            left[i] = i == 0 ? height[i] : Math.max(left[i - 1], height[i]);
        for (int i = len - 1; i >= 0; i--) 
            right[i] = i == (len - 1) ? height[i] : Math.max(right[i + 1], height[i]);
        for (int i = 0; i < len; i++) 
            res += Math.min(left[i], right[i]) - height[i];
        
        return res;
    }
}