class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length < 2)
            return 0;
        
        int max = 0;
        int left = 0;
        int right = height.length-1;
        
        while (right > left) {
            max = Math.max(max, (right-left)*Math.min(height[left], height[right]));
            if (height[right] >= height[left])
                left++;
            else
                right--;
        }
        
        return max;
    }
}
