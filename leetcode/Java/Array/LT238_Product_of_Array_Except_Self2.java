class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        
        int product = 1;
        List<Integer> zero = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                zero.add(i);
            } else {
                product = product * nums[i];   
            }
        }
        
        if (zero.size() > 1) 
            return res;
        else if (zero.size() == 1) { 
            res[zero.get(0)] = product; 
        } else {
            for (int i = 0; i < nums.length; ++i) {
                res[i] = product / nums[i];
            }   
        }
        return res;
    }
}